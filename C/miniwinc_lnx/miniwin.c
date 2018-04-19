
/*
 *  MiniWin: Un mini-conjunto de funciones para abrir una ventana, pintar en
 *    ella y detectar la presiÃ³n de algunas teclas. BÃ¡sicamente para hacer
 *    juegos sencillos.
 *
 *  (c) Pau FernÃ¡ndez, licencia MIT: http://es.wikipedia.org/wiki/MIT_License
 */

// VERSION: 0.2.1

#if defined(_WIN32)

// Windows ////////////////////////////////////////////////////////////////////////////

#ifdef __cplusplus
#include <fstream>
#include <sstream>
#endif // __cplusplus

#include <math.h>
#include <process.h>
#include <windows.h>
#include <windowsx.h>

#define MINIWIN_SOURCE
#include "miniwin.h"

LRESULT CALLBACK WindowProcedure (HWND, UINT, WPARAM, LPARAM);

char szClassName[ ] = "MiniWin";

// Variables globales //////////////////////////////////////////////////////////

HWND            hWnd;              // ventana principal
HBITMAP         hBitmap;           // bitmap para pintar off-screen
int             iWidth  = 400;     // ancho de la ventana
int             iHeight = 300;     // alto de la ventana
HDC             hDCMem = NULL;     // Device Context en memoria

#ifdef __cplusplus
std::queue<int> _teclas;           // cola de teclas
#else                              // en realidad almacena sus códigos enteros
struct cola_entera _teclas;
#endif // __cplusplus

bool            _raton_dentro;     // el raton está dentro del 'client area'
int             _xraton, _yraton;  // posicion del raton
bool            _bot_izq, _bot_der;// botones izquierdo y derecho

////////////////////////////////////////////////////////////////////////////////

#ifdef __cplusplus
std::ostream& log() {
#if defined(DEBUG)
   static std::ofstream _log("log.txt");
#else
   static std::stringstream _log;
   _log.str(""); // lo borra
#endif
   return _log;
}
#endif // __cplusplus

VOID Thread(PVOID pvoid) {
   Sleep(50); // FIXME
   _main_();
}

void maybe_call_main() {
   static bool started = false;
   if (!started) {
      _beginthread(Thread, 0, NULL); // Llama a 'main' (realmente  '_main_')
      started = true;
   }
}

void frame_real(int w, int h, int SIGNO_REF rw, int SIGNO_REF rh) {
   RECT frame = { 0, 0, w, h };
   AdjustWindowRect(&frame, WS_OVERLAPPEDWINDOW, FALSE);
   DES_REF rw = frame.right - frame.left;
   DES_REF rh = frame.bottom - frame.top;
}

void newMemDC(int w, int h) {
   if (hDCMem != NULL) {
      DeleteObject(hBitmap);
      DeleteDC(hDCMem);
   }

   #ifdef __cplusplus
   log() << "New MemDC\n";
   #endif // __cplusplus

   HDC hDC = GetDC(hWnd);
   hDCMem  = CreateCompatibleDC(hDC);
   hBitmap = CreateCompatibleBitmap (hDC, w, h);
   SelectObject(hDCMem, hBitmap);
   SetBkMode(hDCMem, TRANSPARENT);
}

int WINAPI WinMain (HINSTANCE hThisInstance,
                    HINSTANCE hPrevInstance,
                    LPSTR lpszArgument,
                    int nFunsterStil)
{
    static WNDCLASSEX wincl;
    wincl.hInstance     = hThisInstance;
    wincl.lpszClassName = szClassName;
    wincl.lpfnWndProc   = WindowProcedure;
    wincl.style         = CS_DBLCLKS;
    wincl.cbSize        = sizeof (WNDCLASSEX);

    wincl.hIcon   = LoadIcon (NULL, IDI_APPLICATION);
    wincl.hIconSm = LoadIcon (NULL, IDI_APPLICATION);
    wincl.hCursor = LoadCursor (NULL, IDC_ARROW);
    wincl.lpszMenuName  = NULL;
    wincl.cbClsExtra    = 0;
    wincl.cbWndExtra    = 0;
    wincl.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);

    if (!RegisterClassEx (&wincl))
       return 0;

    int w, h;
    frame_real(iWidth, iHeight, GET_REF w, GET_REF h);

    hWnd = CreateWindowEx (
      0,                   /* Extended possibilites for variation */
      szClassName,         /* Classname */
      "MiniWin",           /* Title Text */
      WS_OVERLAPPEDWINDOW, /* default window */
      CW_USEDEFAULT,       /* Windows decides the position */
      CW_USEDEFAULT,       /* where the window ends up on the screen */
      w,                   /* The programs width */
      h,                   /* and height in pixels */
      HWND_DESKTOP,        /* The window is a child-window to desktop */
      NULL,                /* No menu */
      hThisInstance,       /* Program Instance handler */
      NULL                 /* No Window Creation data */
    );

    hBitmap = NULL;

    ShowWindow (hWnd, nFunsterStil);

    MSG messages;
    while (GetMessage (&messages, NULL, 0, 0)) {
       TranslateMessage(&messages);
       DispatchMessage(&messages);
    }

    return messages.wParam;
}

LRESULT CALLBACK WindowProcedure (HWND hWnd,
                                  UINT message,
                                  WPARAM wParam,
                                  LPARAM lParam)
{
   switch (message) {
   case WM_SIZE: {
      #ifdef __cplusplus
      log() << "WM_SIZE\n";
      #endif // __cplusplus
      RECT R;
      GetClientRect(hWnd, &R);
      int w = R.right - R.left;
      int h = R.bottom - R.top;
      #ifdef __cplusplus
      log() << w << ' ' << h << ' ' << '\n';
      #endif // __cplusplus
      if (w == 0 && h == 0) break; // Al minimizar envia WM_SIZE(0,0)

      if (hDCMem == NULL || w != iWidth || h != iHeight) {
         newMemDC(w, h);
         maybe_call_main();
      }
      break;
   }
   case WM_SIZING: {
      RECT* pRECT = (RECT*)lParam;
      #ifdef __cplusplus
      log() << pRECT->top << ' ' << pRECT->left << ' '
            << pRECT->bottom << ' ' << pRECT->right << '\n';
      log() << iHeight << '\n';
      #endif // __cplusplus
      int w, h;
      frame_real(iWidth, iHeight, GET_REF w, GET_REF h);
      switch (wParam) {
      case WMSZ_BOTTOM:
         pRECT->bottom = pRECT->top + h;
         break;
      case WMSZ_TOP:
         pRECT->top = pRECT->bottom - h;
         break;
      case WMSZ_RIGHT:
         pRECT->right = pRECT->left + w;
         break;
      case WMSZ_LEFT:
         pRECT->left = pRECT->right - w;
         break;
      case WMSZ_TOPLEFT:
         pRECT->top = pRECT->bottom - h;
         pRECT->left = pRECT->right - w;
         break;
      case WMSZ_TOPRIGHT:
         pRECT->top = pRECT->bottom - h;
         pRECT->right = pRECT->left + w;
         break;
      case WMSZ_BOTTOMLEFT:
         pRECT->bottom = pRECT->top + h;
         pRECT->left = pRECT->right - w;
         break;
      case WMSZ_BOTTOMRIGHT:
         pRECT->bottom = pRECT->top + h;
         pRECT->right = pRECT->left + w;
         break;
      }

      return TRUE;
   }
   case WM_PAINT: {
      #ifdef __cplusplus
      log() << "WM_PAINT\n";
      #endif // __cplusplus
      PAINTSTRUCT ps;
      HDC hdc = BeginPaint(hWnd, &ps);
      SelectObject(hDCMem, hBitmap);
      if (hBitmap != NULL) {
         BitBlt(hdc, 0, 0, iWidth, iHeight, hDCMem, 0, 0, SRCCOPY);
      }
      EndPaint(hWnd, &ps);
      break;
   }
   case WM_MOUSEMOVE: {
      #ifdef __cplusplus
      log() << "WM_MOUSEMOVE\n";
      #endif // __cplusplus
      _raton_dentro = true;
      _xraton = GET_X_LPARAM(lParam);
      _yraton = GET_Y_LPARAM(lParam);
      _bot_izq = wParam & MK_LBUTTON;
      _bot_der = wParam & MK_RBUTTON;
      break;
   }
   case WM_MOUSELEAVE: {
      _raton_dentro = false;
      break;
   }
   case WM_LBUTTONDOWN: {
      _bot_izq = true;
      break;
   }
   case WM_LBUTTONUP: {
      _bot_izq = false;
      break;
   }
   case WM_RBUTTONDOWN: {
      _bot_der = true;
      break;
   }
   case WM_RBUTTONUP: {
      _bot_der = false;
      break;
   }
   case WM_KEYDOWN: {
     bool push_it = false;

     // Escape
     push_it |= (wParam == VK_ESCAPE);

     // Flechas
     push_it |= (wParam == VK_LEFT ||
                 wParam == VK_RIGHT ||
                 wParam == VK_UP ||
                 wParam == VK_DOWN);

     // Barra espaciadora
     push_it |= (wParam == VK_SPACE);

     push_it |= (wParam == VK_RETURN);

     // Números 0-9
     push_it |= (wParam >= 48 && wParam <= 57);

     // Letras A-Z
     push_it |= (wParam >= 65 && wParam <= 90);

     // Teclas de función
     for (unsigned int i = 0; i < 10; i++) {
       push_it |= (wParam == (VK_F1 + i));
     }

     if (push_it)
        #ifdef __cplusplus
        _teclas.push(wParam);
        #else
        meter(&_teclas, wParam);
        #endif // __cplusplus

     break;
   }
   case WM_DESTROY: {
      DeleteObject (hBitmap);
      DeleteDC (hDCMem);
      PostQuitMessage(0);
      break;
   }
   default:
      return DefWindowProc (hWnd, message, wParam, lParam);
   }

    return 0;
}

////////////////////////////////////////////////////////////////////////////////
//
//   Funciones del API
//
////////////////////////////////////////////////////////////////////////////////

COLORREF _color = RGB(255, 255, 255);

#ifdef __cplusplus
namespace miniwin {
#endif // __cplusplus

int tecla() {
    #if __cplusplus
    if (_teclas.empty())
    #else
    if (cola_vacia(&_teclas))
    #endif // __cplusplus
        return NINGUNA;

    int ret = NINGUNA;
    switch(
           #ifdef __cplusplus
           _teclas.front()
           #else
           primero(&_teclas)
           #endif // __cplusplus
           ) {
    case VK_LEFT:   ret = IZQUIERDA; break;
    case VK_RIGHT:  ret = DERECHA; break;
    case VK_UP:     ret = ARRIBA; break;
    case VK_DOWN:   ret = ABAJO; break;
    case VK_ESCAPE: ret = ESCAPE; break;
    case VK_SPACE:  ret = ESPACIO; break;
    case VK_RETURN: ret = RETURN; break;
    case VK_F1:     ret = F1; break;
    case VK_F2:     ret = F2; break;
    case VK_F3:     ret = F3; break;
    case VK_F4:     ret = F4; break;
    case VK_F5:     ret = F5; break;
    case VK_F6:     ret = F6; break;
    case VK_F7:     ret = F7; break;
    case VK_F8:     ret = F8; break;
    case VK_F9:     ret = F9; break;
    case VK_F10:    ret = F10; break;
    default:
        #ifdef __cplusplus
        ret = _teclas.front();
        #else
        ret = primero(&_teclas);
        #endif // __cplusplus
    }

    #ifdef __cplusplus
    _teclas.pop();
    #else
    sacar(&_teclas);
    #endif // __cplusplus
    return ret;
}

bool raton(float SIGNO_REF x, float SIGNO_REF y) {
   if (!_raton_dentro) {
      return false;
   }
   DES_REF x = _xraton;
   DES_REF y = _yraton;
   return true;
}

bool raton_dentro(void) {
   return _raton_dentro;
}

float raton_x(void) {
   return _xraton;
}

float raton_y(void) {
   return _yraton;
}

void raton_botones(bool SIGNO_REF izq, bool SIGNO_REF der) {
   DES_REF izq = _bot_izq;
   DES_REF der = _bot_der;
}

bool raton_boton_izq(void) {
   return _bot_izq;
}

bool raton_boton_der(void) {
   return _bot_der;
}

void espera(int miliseg) {
   Sleep(miliseg);
}

void mensaje(TIPO_CADENA msj) {
   MessageBox(hWnd, TEXTO(msj), "Mensaje...", MB_OK);
}

bool pregunta(TIPO_CADENA msj) {
   return MessageBox(hWnd, TEXTO(msj), "Pregunta...", MB_OKCANCEL) == IDOK;
}

void borra(void) {
   RECT R;
   SetRect(&R, 0, 0, iWidth, iHeight);
   HBRUSH hBrush = CreateSolidBrush(RGB(0, 0, 0));
   FillRect(hDCMem, &R, hBrush);
   DeleteObject(hBrush);
}

void refresca() {
   InvalidateRect(hWnd, NULL, FALSE);
}

void punto(float x, float y) {
  SetPixel(hDCMem, (int)x, (int)y, _color);
}

void linea(float x_ini, float y_ini, float x_fin, float y_fin) {
   BeginPath(hDCMem);
   MoveToEx(hDCMem, (int)x_ini, (int)y_ini, NULL);
   LineTo(hDCMem, (int)x_fin, (int)y_fin);
   EndPath(hDCMem);
   HPEN hPen = CreatePen(PS_SOLID, 1, _color);
   SelectObject(hDCMem, hPen);
   StrokePath(hDCMem);
   DeleteObject(hPen);
}

static inline void _rect(float izq, float arr, float der, float aba);
inline void _rect(float izq, float arr, float der, float aba) {
   BeginPath(hDCMem);
   MoveToEx(hDCMem, (int)izq, (int)arr, NULL);
   LineTo(hDCMem, (int)izq, (int)aba);
   LineTo(hDCMem, (int)der, (int)aba);
   LineTo(hDCMem, (int)der, (int)arr);
   LineTo(hDCMem, (int)izq, (int)arr);
   EndPath(hDCMem);
}

void rectangulo(float izq, float arr, float der, float aba) {
   HPEN hPen = CreatePen(PS_SOLID, 1, _color);
   HGDIOBJ orig = SelectObject(hDCMem, hPen);
   _rect(izq, arr, der, aba);
   StrokePath(hDCMem);
   SelectObject(hDCMem, orig);
   DeleteObject(hPen);
}

void rectangulo_lleno(float izq, float arr, float der, float aba) {
   HBRUSH hBrush = CreateSolidBrush(_color);
   HGDIOBJ orig = SelectObject(hDCMem, hBrush);
   _rect(izq, arr, der, aba);
   FillPath(hDCMem);
   SelectObject(hDCMem, orig);
   DeleteObject(hBrush);
}

static inline void _circ(float x_cen, float y_cen, float radio);
inline void _circ(float x_cen, float y_cen, float radio) {
   BeginPath(hDCMem);
   Arc(hDCMem, (int)(x_cen - radio), (int)(y_cen - radio),
               (int)(x_cen + radio), (int)(y_cen + radio),
               (int)(x_cen - radio), (int)(y_cen - radio),
               (int)(x_cen - radio), (int)(y_cen - radio));
   EndPath(hDCMem);
}

void circulo(float x_cen, float y_cen, float radio) {
   HPEN hPen = CreatePen(PS_SOLID, 1, _color);
   HGDIOBJ orig = SelectObject(hDCMem, hPen);
   _circ(x_cen, y_cen, radio);
   StrokePath(hDCMem);
   SelectObject(hDCMem, orig);
   DeleteObject(hPen);
}

void circulo_lleno(float x_cen, float y_cen, float radio) {
   HBRUSH hBrush = CreateSolidBrush(_color);
   HGDIOBJ orig = SelectObject(hDCMem, hBrush);
   _circ(x_cen, y_cen, radio);
   FillPath(hDCMem);
   SelectObject(hDCMem, orig);
   DeleteObject(hBrush);
}

void texto(float x, float y, const TIPO_CADENA texto) {
   SetTextColor(hDCMem, _color);
   TextOut(hDCMem, (int)x, (int)y, TEXTO(texto), (int)LARGO(texto));
}

static COLORREF _colores[] = {
   RGB(0, 0, 0),       // NEGRO
   RGB(255, 0, 0),     // ROJO
   RGB(0, 255, 0),     // VERDE
   RGB(0, 0, 255),     // AZUL
   RGB(255, 255, 0),   // AMARILLO
   RGB(255, 0, 255),   // MAGENTA
   RGB(0, 255, 255),   // CYAN
   RGB(255, 255, 255), // BLANCO
};

void color(int c) {
   _color = _colores[c];
}

void color_rgb(int r, int g, int b) {
   _color = RGB(r, g, b);
}

int vancho() {
   return iWidth;
}

int valto() {
   return iHeight;
}

void vredimensiona(int ample, int alt) {
   iWidth = ample;
   iHeight = alt;
   int w, h;
   frame_real(iWidth, iHeight, GET_REF w, GET_REF h);
   SetWindowPos(hWnd, NULL, 0, 0, w, h, SWP_NOMOVE);
   newMemDC(w, h);
}

void vcierra() {
  PostMessage(hWnd, WM_CLOSE, 0, 0);
}

#ifdef __cplusplus
} // namespace miniwin
#endif // __cplusplus

///////////////////////////////////////////////////////////////////////////////////////

#elif defined(__linux)

// Linux //////////////////////////////////////////////////////////////////////////////


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#ifdef __cplusplus
#include <iostream>
#endif

#include <X11/Xlib.h>
#include <X11/Xutil.h>
#include <X11/Xos.h>
#include <X11/Xatom.h>
#include <X11/keysym.h>

#ifdef __cplusplus
using namespace std;
#endif // __cplusplus

#define MINIWIN_SOURCE
#include "miniwin.h"

// Globals ///////////////////////////////////////////////////////////

int             _width  = 400;
int             _height = 300;
Display        *_dsp;
Window          _win;
XEvent          _report;
GC              _bufgc;
Pixmap          _buffer;

#ifdef __cplusplus
std::queue<int> _teclas;
#else
struct cola_entera _teclas;
#endif // __cplusplus

bool            _end = false;
pthread_t       _thread;
pthread_mutex_t _mutex = PTHREAD_MUTEX_INITIALIZER;

//////////////////////////////////////////////////////////////////////

int rgbs[][3] = {
   {   0,   0,   0 }, // NEGRO
   { 255,   0,   0 }, // ROJO
   {   0, 255,   0 }, // VERDE
   {   0,   0, 255 }, // AZUL
   { 255, 255,   0 }, // AMARILLO
   { 255,   0, 255 }, // MAGENTA
   {   0, 255, 255 }, // CYAN
   { 255, 255, 255 }, // BLANCO
};

static inline void _color_rgb(int r, int g, int b);
inline void _color_rgb(int r, int g, int b) {
   unsigned long pixel;
   pixel = (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF);
   XSetForeground(_dsp, _bufgc, pixel);
}

static inline int _color(int col);
inline int _color(int col) {
   static int _curr = 0;
   int ret = _curr;
   if (col >= 0 && col < 8) {
      _color_rgb(rgbs[col][0], rgbs[col][1], rgbs[col][2]);
      _curr = col;
   }
   return ret;
}

static inline void _fill(void);
inline void _fill(void) {
   XFillRectangle(_dsp, _buffer, _bufgc, 0, 0, _width, _height);
}

static inline void _refresh();
inline void _refresh(void) {
   XCopyArea(_dsp, _buffer, _win, _bufgc,
             0, 0, _width, _height, 0, 0);
   XFlush(_dsp);
}

static inline void _lock(void);
static inline void _unlock(void);
inline void _lock(void)   { pthread_mutex_lock(&_mutex); }
inline void _unlock(void) { pthread_mutex_unlock(&_mutex); }

void _handlekey(KeySym key) {
   switch (key) {
   #ifdef __cplusplus
   case XK_Escape: _teclas.push(miniwin::ESCAPE); break;
   case XK_space:  _teclas.push(miniwin::ESPACIO); break;
   case XK_Return: _teclas.push(miniwin::RETURN); break;
   case XK_Left:   _teclas.push(miniwin::IZQUIERDA); break;
   case XK_Right:  _teclas.push(miniwin::DERECHA); break;
   case XK_Up:     _teclas.push(miniwin::ARRIBA); break;
   case XK_Down:   _teclas.push(miniwin::ABAJO); break;
   #else
   case XK_Escape: meter(&_teclas, ESCAPE);    break;
   case XK_space:  meter(&_teclas, ESPACIO);   break;
   case XK_Return: meter(&_teclas, RETURN);    break;
   case XK_Left:   meter(&_teclas, IZQUIERDA); break;
   case XK_Right:  meter(&_teclas, DERECHA);   break;
   case XK_Up:     meter(&_teclas, ARRIBA);    break;
   case XK_Down:   meter(&_teclas, ABAJO);     break;
   #endif // __cplusplus
   default: {
      if ((key >= (int)'0' && key <= (int)'9') ||
          (key >= (int)'A' && key <= (int)'Z') ||
          (key >= (int)'a' && key <= (int)'z')) {
         #ifdef __cplusplus
         teclas.push(key);
         #else
         meter(&_teclas, key);
         #endif // __cplusplus
      } else if (key >= XK_F1 && key <= XK_F10) {
         int dif = key - XK_F1;
         #ifdef __cplusplus
         _teclas.push(miniwin::F1 + dif);
         #else
         meter(&_teclas, F1 + dif);
         #endif // __cplusplus
      }
   }
   }
}

void _change_width_height(int w, int h) {
   XWindowChanges changes;
   changes.width  = w;
   changes.height = h;
   XConfigureWindow(_dsp, _win, CWWidth | CWHeight, &changes);
}

struct _mouse_state_t {
   float x, y;
   bool in_window, left_button, right_button;
} _mouse_state;

void _open_display(void) {
   // "XInitThreads must be the first Xlib function a multi-threaded program calls"
   // http://tronche.com/gui/x/xlib/display/XInitThreads.html
   /* XInitThreads(); */
	_dsp = XOpenDisplay(NULL);
}

void _new_window(void) {
	_win = XCreateSimpleWindow(_dsp, RootWindow(_dsp, 0),
                              0, 0, _width, _height,
                              0, BlackPixel (_dsp, 0), BlackPixel(_dsp, 0));
	XSelectInput(_dsp, _win,
                StructureNotifyMask |
                ExposureMask |
                KeyPressMask |
                ButtonPressMask |
                PointerMotionMask |
                ButtonPressMask |
                ButtonReleaseMask |
                EnterWindowMask |
                LeaveWindowMask
                );
	XMapWindow(_dsp, _win);

   // To know when is closed:
   // http://cboard.cprogramming.com/linux-programming/60466-xwindows-close-window-event.html
   Atom wmDelete = XInternAtom(_dsp, "WM_DELETE_WINDOW", True);
   XSetWMProtocols(_dsp, _win, &wmDelete, 1);
}

void _close_window(void) {
   XDestroyWindow(_dsp, _win);
}

void _new_buffer(bool free
                 #ifdef __cplusplus
                  = false // Si pensabas que lo del main era cutre seguro que no habias visto esto
                  #endif // __cplusplus
                  ) {
   if (free) {
      XFreePixmap(_dsp, _buffer);
      XFreeGC(_dsp, _bufgc);
   }
   XWindowAttributes attrs;
   XGetWindowAttributes(_dsp, _win, &attrs);
   _buffer = XCreatePixmap(_dsp, _win, _width, _height, attrs.depth);
	_bufgc = XCreateGC(_dsp, _buffer, 0, 0);

   #ifdef __cplusplus
   _color(miniwin::NEGRO);
   _fill();
   _color(miniwin::BLANCO);
   #else
   _color(NEGRO);
   _fill();
   _color(BLANCO);
   #endif // __cplusplus
}

void *_invoke_main(void * p) {
   _main_();
   pthread_exit(NULL);
}

void _maybe_call_main(void) {
   static bool started = false;
   if (!started) {
      started = true;
      pthread_create(&_thread, NULL, _invoke_main, NULL);
   }
}

void _process_event(void) {
   switch  (_report.type) {
   case Expose: {
      _refresh();
      break;
   }
   case KeyPress: {
      KeySym key = XLookupKeysym(&_report.xkey, 0);
      _handlekey(key);
      break;
   }
   case MapNotify: {
      _maybe_call_main();
      break;
   }
   case ClientMessage: {
      // WM_DELETE_WINDOW
      _end = true;
      break;
   }
   case MotionNotify: {
      _mouse_state.x = _report.xmotion.x;
      _mouse_state.y = _report.xmotion.y;
      break;
   }
   case ButtonPress: {
      switch (_report.xbutton.button) {
      case 1: _mouse_state.left_button  = true; break;
      case 3: _mouse_state.right_button = true; break;
      }
      break;
   }
   case ButtonRelease: {
      switch (_report.xbutton.button) {
      case 1: _mouse_state.left_button = false; break;
      case 3: _mouse_state.right_button = false; break;
      }
      break;
   }
   case EnterNotify:
   case LeaveNotify: {
      _mouse_state.in_window = (_report.type == EnterNotify);
      break;
   }
   }
}

int main(void) {
   _open_display();
   _new_window();
   _new_buffer(false);

	while (!_end)  {
       _lock();
       if (XPending(_dsp) > 0) {
          XNextEvent(_dsp, &_report); // this blocks
          _process_event();
       }
       _unlock();
       usleep(100);
	}
   pthread_cancel(_thread);
   XDestroyWindow(_dsp, _win);
   XCloseDisplay(_dsp);
   pthread_exit(NULL);
}


////////////////////////////////////////////////////////////////////////////////
//
//   Funciones del API
//
////////////////////////////////////////////////////////////////////////////////

#ifdef __cplusplus
namespace miniwin {
#endif // __cplusplus

void vredimensiona(int ancho, int alto) {
   _lock();
   _change_width_height(ancho, alto);
   _unlock();
   _width  = ancho;
   _height = alto;
   _lock();
   _new_buffer(true);
   _unlock();
}

int vancho(void) {
  return _width;
}

int valto(void) {
  return _height;
}

void vcierra(void) {
   _lock();
   _end = true;
   XUnmapWindow(_dsp, _win);
   XFlush(_dsp);
   _unlock();
}

void punto(float x, float y) {
   _lock();
   XDrawPoint(_dsp, _buffer, _bufgc, x, y);
   _unlock();
}

void linea(float x_ini, float y_ini, float x_fin, float y_fin) {
   // cerr << "linea(" << x_ini << ", " << y_ini << ", " << x_fin << ", " << y_fin << ")" << endl;
   _lock();
   XDrawLine(_dsp, _buffer, _bufgc, x_ini, y_ini, x_fin, y_fin);
   _unlock();
}

void rectangulo(float izq, float arr, float der, float aba) {
   _lock();
   XDrawRectangle(_dsp, _buffer, _bufgc, izq, arr, der - izq, aba - arr);
   _unlock();
}

void rectangulo_lleno(float izq, float arr, float der, float aba) {
   _lock();
   XFillRectangle(_dsp, _buffer, _bufgc, izq, arr, der - izq, aba - arr);
   _unlock();
}

void circulo(float x_cen, float y_cen, float radio) {
   float x = x_cen - radio, y = y_cen - radio;
   _lock();
   XDrawArc(_dsp, _buffer, _bufgc, x, y, 2*radio, 2*radio, 0, 360 * 64);
   _unlock();
}

void circulo_lleno(float x_cen, float y_cen, float radio) {
   float x = x_cen - radio, y = y_cen - radio;
   _lock();
   XFillArc(_dsp, _buffer, _bufgc, x, y, 2*radio, 2*radio, 0, 360 * 64);
   _unlock();
}

void texto(float x, float y, const TIPO_CADENA texto) {
   _lock();
   XDrawString(_dsp, _buffer, _bufgc, x, y, TEXTO(texto), LARGO(texto));
   _unlock();
}

void color_rgb(int r, int g, int b) {
   _lock();
   _color_rgb(r, g, b);
   _unlock();
}

void color(int col) {
   _lock();
   _color(col);
   _unlock();
}


void refresca(void) {
   XEvent event;
   event.type = Expose;
   event.xexpose.window = _win;
   // repintar sin borrar (evitar XClearArea...)
   _lock();
   XSendEvent(_dsp, _win, False, ExposureMask, &event);
   XFlush(_dsp);
   _unlock();
}

void borra(void) {
   #ifdef __cplusplus
   int prev = _color(miniwin::NEGRO);
   #else
   int prev = _color(NEGRO);
   #endif // __cplusplus
   _lock();
   _fill();
   _color(prev);
   _unlock();
}

int tecla(void) {
   #ifdef __cplusplus
   if (_teclas.empty()) {
   #else
   if (cola_vacia(&_teclas)) {
   #endif
      return NINGUNA;
   } else {
      #ifdef __cplusplus
      int t = _teclas.front();
      _lock();
      _teclas.pop();
      #else
      int t = primero(&_teclas);
      _lock();
      sacar(&_teclas);
      #endif // __cplusplus

      _unlock();
      return t;
   }
}

bool raton(float SIGNO_REF x, float SIGNO_REF y) {
   DES_REF x = _mouse_state.x;
   DES_REF y = _mouse_state.y;
   return _mouse_state.in_window;
}

bool raton_dentro(void) {
   return _mouse_state.in_window;
}

float raton_x(void) {
   return _mouse_state.x;
}

float raton_y(void) {
   return _mouse_state.x;
}

bool raton_boton_izq(void) {
   return _mouse_state.left_button;
}

bool raton_boton_der(void) {
   return _mouse_state.right_button;
}

void raton_botones(bool SIGNO_REF izq, bool SIGNO_REF der) {
   DES_REF izq = _mouse_state.left_button;
   DES_REF der = _mouse_state.right_button;
}


void mensaje(TIPO_CADENA msj) {
   #ifdef __cplusplus
   cerr << "Mensaje:" << msj << endl;
   #else
   printf("Mensaje: %s", msj);
   #endif // __cplusplus
}

bool pregunta(TIPO_CADENA msj) {
   #ifdef __cplusplus
   cerr << "Pregunta:" << msj << endl;
   #else
   printf("Pregunta: %s", msj);
   #endif // __cplusplus
   return false;
}

void espera(int miliseg) {
   usleep(miliseg * 1000);
}

#ifdef __cplusplus
} // namespace miniwin
#endif // __cplusplus

///////////////////////////////////////////////////////////////////////////////////////

#else

#error "MiniWin no funciona en esta plataforma"

#endif

int esperarTecla(void) {
    int t;
    while ( (t = tecla()) == NINGUNA );

    return t;
}

#ifndef __cplusplus

#include <assert.h>

struct CE_nodo_cola {
    int dato;
    struct CE_nodo_cola *siguiente;
};

struct cola_entera {
    struct CE_nodo_cola *primero, *ultimo;
};

void meter(struct cola_entera *c, int dato) {
    if ( c->primero == NULL )
    {
        c->primero = c->ultimo = calloc(1, sizeof(struct CE_nodo_cola));
        c->primero->dato = dato;
    }
}
void sacar(struct cola_entera * c) {
    assert(!cola_vacia(c));
    struct CE_nodo_cola *auxiliar = c->primero;
    c->primero = c->primero->siguiente;
    free(auxiliar);
}

int primero(const struct cola_entera * c) {
    assert(!cola_vacia(c));
    return c->primero->dato;
}

bool cola_vacia(const struct cola_entera * c) {
    return c->primero == NULL;
}

#endif // __cplusplus


/*
 *  MiniWin: Un mini-conjunto de funciones para abrir una ventana, pintar en
 *    ella y detectar la presión de algunas teclas. Básicamente para hacer
 *    juegos sencillos.
 *
 *  (c) Pau Fernández, licencia MIT: http://es.wikipedia.org/wiki/MIT_License
 */

// VERSION: 0.2.1


#ifndef _MINIWIN_H_
#define _MINIWIN_H_

#ifdef __cplusplus
#include <iostream>
#include <queue>
#include <string>

#define SIGNO_REF &   // Las referencias en C++ usan '&'
#define GET_REF       // No se requiere signo para obtener referencia en C++
#define DES_REF       // No se requiere desreferenciar

#define TIPO_CADENA std::string      // C++ usa la clase cadena de la STL
#define TEXTO(cadena) cadena.c_str()
#define LARGO(cadena) (cadena.size())

#else
#include <stdbool.h>
#include <string.h>

#define SIGNO_REF *   // Las referencias en C se SIMULAN con '*'
#define GET_REF   &   // C requiere '&' para obtener una direcciOn de memoria
#define DES_REF   *   // Se requiere '*' para desreferenciar

#define TIPO_CADENA char *   // C usa simples arreglos de caracteres
#define TEXTO(cadena) cadena
#define LARGO(cadena) (strlen(cadena))

struct cola_entera; // Definiremos nuestra propia cola y sus funciones

void meter(struct cola_entera *, int);
void sacar(struct cola_entera *);

int primero(const struct cola_entera *);
bool cola_vacia(const struct cola_entera *);

#endif // __cplusplus


#ifndef MINIWIN_SOURCE
#define main _main_ // Super-cutre hack! (pero funciona)
#endif

int _main_();

#ifdef __cplusplus
std::ostream& log();
#endif // __cplusplus

// Funciones del API

#ifdef __cplusplus
namespace miniwin {
#endif // __cplusplus

void borra(void);
void refresca(void);
void mensaje(TIPO_CADENA msj);
bool pregunta(TIPO_CADENA msj);
void espera(int miliseg);

int  vancho(void);
int  valto(void);
void vredimensiona(int ample, int alt);
void vcierra(void);

void color(int c);
void color_rgb(int r, int g, int b);

void punto(float x, float y);
void linea(float x_ini, float y_ini, float x_fin, float y_fin);
void rectangulo(float izq, float arr, float der, float aba);
void rectangulo_lleno(float izq, float arr, float der, float aba);
void circulo(float x_cen, float y_cen, float radio);
void circulo_lleno(float x_cen, float y_cen, float radio);
void texto(float x, float y, const TIPO_CADENA texto);

int tecla(void);
int esperarTecla(void);

bool  raton(float SIGNO_REF x, float SIGNO_REF y);
bool  raton_dentro(void);
float raton_x(void);
float raton_y(void);
void  raton_botones(bool SIGNO_REF izq, bool SIGNO_REF der);
bool  raton_boton_izq(void);
bool  raton_boton_der(void);

enum {
  ESCAPE,
  IZQUIERDA, DERECHA, ARRIBA, ABAJO,
  F1, F2, F3, F4, F5, F6, F7, F8, F9, F10,
  ESPACIO,
  RETURN,
  NINGUNA
};

enum {
  NEGRO, ROJO, VERDE, AZUL,
  AMARILLO, MAGENTA, CYAN, BLANCO
};

#ifdef __cplusplus
} // namespace miniwin
#endif // __cplusplus

#endif



%%%%%%HECHOS
%instancia_de(Objeto, Clase)
instancia_de(messi, futbol_campo).
instancia_de(ronaldo, futbol_campo).
instancia_de(lebron, tradicional_baloncesto).
instancia_de(bolt, carrera_atletismo).
instancia_de(dressel, libre_natacion).
instancia_de(michael, espalda_natacion).
instancia_de(thiago, mariposa_natacion).

%subclase(Subclase, Clase)
subclase_de(deporte_individual, deporte).
subclase_de(deporte_colectivo, deporte).
subclase_de(atletismo, deporte_individual).
subclase_de(carrera_atletismo, atletismo).
subclase_de(natacion, deporte_individual).
subclase_de(libre_natacion, natacion).
subclase_de(espalda_natacion, natacion).
subclase_de(mariposa_natacion, natacion).
subclase_de(tenis, deporte_individual).
subclase_de(golf, deporte_individual).
subclase_de(futbol, deporte_colectivo).
subclase_de(futbol_sala, futbol).
subclase_de(futbol_campo, futbol).
subclase_de(futbol_americano, deporte_colectivo).
subclase_de(baloncesto, deporte_colectivo).
subclase_de(tradicional_baloncesto, baloncesto).
subclase_de(tres_por_tres_baloncesto, baloncesto).

%tiene_propiedad(Clase1, propiedad, Clase2)
tiene_propiedad(deporte, requiere, actividad_fisica).
tiene_propiedad(deporte, requiere, habilidad).
tiene_propiedad(deporte_colectivo, requiere, equipo).
tiene_propiedad(futbol_sala, se_juega_en, cancha_indoor).
tiene_propiedad(futbol_americano, se_juega_con, balon_ovalado).
tiene_propiedad(tres_por_tres_baloncesto, se_juega_en, media_cancha).
tiene_propiedad(atletismo, se_practica_en, pista).
tiene_propiedad(tenis, se_juega_con, raqueta).
tiene_propiedad(golf, se_juega_con, palo).
tiene_propiedad(mariposa_natacion, requiere, mucha_practica).

%%%%%%REGLAS
%Regla para saber si un objeto es una instancia de una clase en concreto
es(Clase, Obj):-instancia_de(Obj, Clase).
es(Clase, Obj):-instancia_de(Obj, Clasep),
                subc(Clasep, Clase).

%Regla para saber si una clase es subclase de otra
subc(C1, C2):-subclase_de(C1,C2).
subc(C1, C2):-subclase_de(C1,C3),
              subc(C3,C2).

%Regla para saber las propiedades de un objeto
propiedad(Obj,Prop):-es(Clase,Obj),
                     tiene_propiedad(Clase,Propiedad,Clase2),
                     Prop =.. [Propiedad, Clase2].


%Algunas pruebas realizadas con su salida:
% es(libre_natacion,dressel).
    % true
% es(natacion,dressel). 
    % true
% es(deporte_individual,dressel). 
    % true
% es(deporte_colectivo,dressel).
    % false
% es(baloncesto,dressel). 
    % false

% propiedad(messi,X).
%     X = requiere(equipo) ;
%     X = requiere(actividad_fisica) ;
%     X = requiere(habilidad) ;

% propiedad(bolt,X).  
    % X = se_practica_en(pista) ;
    % X = requiere(actividad_fisica) ;
    % X = requiere(habilidad) ;

% propiedad(thiago,X).
    % X = requiere(mucha_practica) ;
    % X = requiere(actividad_fisica) ;
    % X = requiere(habilidad) ;

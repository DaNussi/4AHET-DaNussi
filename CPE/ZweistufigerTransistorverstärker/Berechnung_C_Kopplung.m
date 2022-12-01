%% INIT der Berechnung des 1. CPE Projektes Mehrstufige Transistor Verstärkung
%Berechnung mit Koppelkondensator
%4AHET Jakob Wurst 08.09.2022

%% Parameter
clc;
clear all;
close all;  

B = 230;    %Verstärkung der Transistoren
UQ = 3e-3;  %Eingangsspannung
UB = 16;    %Versorgungsspannung
UBE = 0.6;  %Basis-Emitter Spannung
Ri = 40e3; %Ohm
RL = 470;   %Ohm
RC2 = RL;   %Ohm
fu = 50;   %Messfrequenz
fustr = fu/sqrt(3); %Hz Wegen 3 Kondensatoren sqrt(3)

vu = 70;    %Spannungsverstärkung
Ua = UQ*vu; %Ausgangsspannung mit Verstärkung
Vu1 = 27;    %Verstärkung 1.Transistor
Vu2 = 50;   %Verstärkung 2.Transistor
Vu_neu=Vu1*Vu2;
%% Berechnung 2 Transistor
RE2=RC2/(Vu2*2);
%RE2 = 8.2;%RE2 = 10; %E12 Reihe gewählter Widerstand
URC2 = UB/2;
IC2 = URC2/RC2;
IB2 = IC2/B;
URE2 = RE2*(IC2+IB2);
UR4 = UBE+URE2;
Iq2 =10*IB2;
R4 = UR4/Iq2;
%R4 = 18e3; %R4=2200; %E12 Reihe gewählter Widerstand
UR3 = UB-UR4;
IR3 = IB2+Iq2;
R3 = UR3/IR3;
%R3 = 180e3;   %E12 Reihe gewählter Widerstand
re2str =(1/R3 + 1/R4 + 1/(B*RE2));
re2 = 1/re2str;
C3 = 1/(2*pi*RL*fustr);     %Ausgangskondensatoren
C2 = 1/(2*pi*re2*fustr);    %Koppelkondensator zwischen den Transistorn

%% Berechnung 1. Stufe
RC1 = 3e3;
%RC1 = 2700;   %E12 Reihe gewählter Widerstand
RE1 = (RC1/(Vu1));
RE1 = 200;    %E12 Reihe gewählter Widerstand
URC1 = UB/2;
IC1 = URC1/RC1;
IB1 = IC1/B;
Iq1 = 20*IB1;
URE1 = RE1*(IC1+IB1);
UR2 = UBE+URE1;
R2 = UR2/Iq1;
R2=20e3;    %E12 Reihe gewählter Widerstand
UR1 = UB-UR2;
IR1 = IB1+Iq1;
R1 = UR1/IR1;
R1 = 180e3;     %E12 Reihe gewählter Widerstand
re1str = 1/(1/R1 + 1/R2 + 1/((B)*RE1));
re1 = re1str;
C1 = 1/(2*pi*re1*fustr);    %Eingangskondensator
UA=UQ*(re1/(re1+Ri))*Vu1*(re2/(re2+RC1))*Vu2*(RL/(RL+RC2));
%% Anzeigen der Werte in Window
fprintf('Rc1 %f\n', RC1);
fprintf('Re1 %f\n', RE1);
fprintf('R1 %f\n', R1);
fprintf('R2 %f\n', R2);
fprintf('RC2 %f\n', RC2);
fprintf('RE2 %f\n', RE2);
fprintf('R3 %f\n', R3);
fprintf('R4 %f\n', R4);
fprintf('C1 %f\n', C1);
fprintf('C2 %f\n', C2);
fprintf('C3 %f\n', C3);

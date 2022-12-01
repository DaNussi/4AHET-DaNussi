clc;
clear all;
close all;

%% Parameter
RL  = 470;     %Ohm
Ri  = 40e3;    %Ohm
Vu1 = 12;
Vu2 = 34;
RC2 = 820    %Ohm
Ub  = 11;       %V
B   = 310;           
Ube = 0.7;      %V
Uce = 0.25;     %V  0.6
fu  = 2000;     %Hz
rbe = 50;      %Ohm
%% Berechnung T2
RE2     = RC2/(2*Vu2)
Ic2     = (Ub/2)/RC2;
Ib2     = Ic2/B;
URE2    = RE2*(Ic2+Ib2);
% Widerstand re
re2     = rbe+RE2*(B+1);
% Kondesatoren
fustr   = fu/sqrt(2);
C2      = 1/(2*pi*fustr*RL)
%% Berechnung T1
RC1     = re2
URE1    = Ube + URE2 - Uce;
Ic1     = (Ub-URE1+Uce)/RC1;
Ib1     = Ic1/B;
RE1    = URE1/(Ic1+Ib1)
% Widerstand R2
UR2    = URE1 + Ube;
IR2    = Ib1*10;
R2     = UR2/IR2
% Widerstand R1
UR1    = Ub - UR2;
IR1    = Ib1 * 11;
R1     = UR1 / IR1

% Widerstand ra & re
re1      = ((R1)^-1+(R2)^-1+(RE1*(B+1))^-1)^-1

% Kondesatoren
fustr   = fu/sqrt(2);
C1      = 1/(2*pi*fustr*re1)
%% Anzeigen der Werte in Window
fprintf('Rc1 %f\n', RC1);
fprintf('Re1 %f\n', RE1);
fprintf('R1 %f\n', R1);
fprintf('R2 %f\n', R2);
fprintf('RC2 %f\n', RC2);
fprintf('RE2 %f\n', RE2);
fprintf('C1 %f\n', C1);
fprintf('C2 %f\n', C2);
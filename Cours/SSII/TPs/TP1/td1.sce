xdel(winsid());
clear;

wavfile="1234.WAV"
[sOrig,fmax,b]=wavread(wavfile)
playsnd(sOrig,fmax)
//playsnd(sOrig*10,fmax)
//playsnd(sOrig,fmax*2)
//22000 echantillons en 1 s et le son est d'une longueur de 44072 echantillons donc le son dure environ 2sec
t=[0:length(sOrig)-1]/fmax
//plot2d([0:length(s(1,:)]/fe, s(1,:))
plot2d(t,sOrig)
xgrid
xtitle('1234','t(s)','amplitude')

//son synthétique
N=64
Te=1/8000;
fe=1/Te;
t =[0:1:N-1]*Te
s=0.5*cos(2*%pi*440*t)
fmax=440

playsnd(s,8000)
figure
plot2d(t,s)
xgrid
xtitle(["N=",string(N)],'t(s)','ampliude');


//echantillonage
t2=[0:4:N-1]*Te
fe=8000/4 //car on prends un echanillon sur 4 alors que nous avons 8000 echantillons par seconde
se=s(1:4:N-1)
figure
plot2d(t2,se)
xtitle('echantillonage ','t(s)','amplitude')
disp("condition d echantillonage ",fe>2*fmax);


////
////quantification sur B bits
q=4 //on veut 8=2³ valeurs donc on prend q=8/2=4
seq=(1/q)*floor(s*q)
figure
playsnd(seq,fmax)
plot2d(t,seq)
xtitle('B=3','t(s)','amplitude')

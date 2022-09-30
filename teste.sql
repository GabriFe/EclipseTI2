create table CURSO(
    sigla char(10),
    nome char(50) not null,
    hora int not null,
    custo float not null,
    area char(50) not null,
    primary key(sigla)
);
create table AREA(
    sigla char(10),
    nome char(50) not null,
    superArea char(50) not null,
    primary key(sigla)
);
create table MODULO(
    sigla char(10),
    nome char(50) not null,
    curso char(30) not null,
    primary key(sigla)
);
create table TOPICO(
    modulo char(10),
    sigla char(10),
    nome char(50) not null,
    horas int not null,
    primary key(modulo,sigla)
);
create table MATRICULA(
    curso char(10),
    aluno char(11),
    daata date not null,
    pago boolean not null,
    primary key(curso,aluno)
);
create table ALUNO(
    CPF char(11),
    nome char(50) not null,
    sobrenome char(50) not null,
    sexo char(1) not null,
    dataNasc date not null,
    primary key(CPF)
);
create table PROFESSOR(
    curso char(10),
    CPF char(11),
    nome char(50) not null,
    primary key(curso,CPF)
);
alter table CURSO add foreign key(area) references AREA(sigla);
alter table AREA add foreign key(superArea) references AREA(sigla);
alter table MODULO add foreign key(curso) references CURSO(sigla);
alter table TOPICO add foreign key(modulo) references MODULO(sigla);
alter table MATRICULA add foreign key(curso) references CURSO(sigla);
alter table MATRICULA add foreign key(curso) references ALUNO(CPF);
alter table PROFESSOR add foreign key(curso) references CURSO(sigla);

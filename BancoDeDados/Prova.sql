# SCHEMA EMPRESA - AULA 1
DROP DATABASE IF EXISTS EMPRESA;
CREATE DATABASE IF NOT EXISTS EMPRESA;

USE EMPRESA;
-- show databases;
-- describe ou desc funcionario;
-- show tables

# Criando tabela DFuncionario
create table IF NOT EXISTS Funcionario (
    numero integer not null,
    nome varchar(64),
    rua varchar(32),
    nro integer,
    bairro varchar(20),
    cidade varchar(20),
    estado varchar(2),
    cep varchar(9),
    salario float,
    numeroSupervisor integer,
    primary key(numero),
    foreign key (numeroSupervisor) references Funcionario(numero)
);

# Criando tabela Departamento
create table IF NOT EXISTS Departamento (
    numero integer not null,
    nome varchar(32),
    numeroFuncGer integer,
    dataIniGer date,
    primary key (numero),
    foreign key (numeroFuncGer) references Funcionario(numero)
);
alter table Funcionario add numerodepto integer;
desc Funcionario;

create table IF NOT EXISTS Projeto (
    numero integer not null,
    nome varchar(32),
    numeroDepto integer,
    primary key (numero),
    foreign key (numeroDepto) references Departamento(numero)
);

create table IF NOT EXISTS Dependente (
    numeroFunc integer,
	nome varchar(60) not null,
    dataNasc date,
    parentescpo varchar(50),
    primary key (numeroFunc, nome),
    foreign key (numeroFunc) references Funcionario(numero)
									on delete cascade #efeito cascata
                                    on update cascade
);

create table if not exists LocalDep (
	numeroDepto integer not null,
    localizacao varchar(64) not null,
    primary key (numeroDepto, localizacao),
    foreign key (numeroDepto) references Departamento(numero)
);

create table if not exists FuncProj (
	numeroFunc integer not null,
    numeroProj integer not null,
    horas time,
    primary key (numeroFunc, numeroProj),
    foreign key (numeroFunc) references Funcionario(numero),
    foreign key (numeroProj) references Projeto(numero)
);

#alter table a drop b --> tira o atributo b da tabela a
#alter table a modify B(E O TIPO)
#alter table a change B + modifcação e o tipo
#alter table Dependente change parentescpo parentesco varchar(50);

#inserindo valores na tabela
#insert into Funcionario(numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numerodepto) values(1, 'Vania', 'Rua conselheiro', 341, 'Jardim das Torres', 'São Paulo', 'SP', '12555621', 1200, null, 1);
#insert into Departamento(numero, nome, numeroFuncGer, dataIniGer) values (1, 'Financeiro', 1, '1988-02-15');
#insert into Projeto (numero, nome, numeroDepto) values (1, 'Loucura Total', 1);
#insert into Dependente(numeroFunc, nome, dataNasc, parentesco) value (1, 'Jose', '2006-02-18', 'filho');
#insert into Localdep(numeroDepto, localizacao) values (1, 'a terra do nunca');
#insert into FuncProj (numeroFunc, numeroProj, horas) values (1, 1, '13:31:50');
#delete from where
#consultas
#select nome from funcionario;
#select salario from funcionario;
#delete from departamento; -- não apaga pq tem outras classes veinculadas a ela
#delete from funcionario where salario >= 1000 and salario <= 2000;
#update Funcionario set salario = salario * 1.05 where salario <= 1000;
#select distinct cidade from funcionario;

# *************** INSERINDO VALORES NAS TABELAS FUNCIONARIO **************

insert into Funcionario(numero, nome, rua, nro, bairro, cidade, estado, cep,salario, numeroSupervisor, numerodepto)
values (1,'João', 'Rua Bahia', 483, 'Cidade Jardim', 'Valinhos', 'SP', 23900-000, 3200.30, null, null);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (2, 'Jose', 'Rua Marechal', 27, 'Paulistano', 'Salto', 'SP', '54621-000', 1820.77, 1, 1);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (3, 'Luciano', 'Rua Teodoro', 83, 'Centro', 'Araras', 'SP', '52412-000', 1700, 2, 4);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (4, 'Danilo', 'Rua Vergueiro', 1022, 'Paraiso', 'Sao Paulo', 'SP', '13140-000', 2200.00, 1, 5);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (5, 'Patricia', 'Rua Lima', 63, 'Itaim', 'Sao Paulo', 'SP', '45123-000', 2300.00, 1, 3);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (6, 'Mariana', 'Rua Sansao', 34, 'Jacare', 'Sao Carlos', 'SP', '55981-000', 1200, 1, 5);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (7, 'Cristiano', 'Rua X', 10, 'Centro', 'Araraquara', 'SP', '14524-000', 3500.00, 2, 5);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (8, 'Fabiano', 'Rua III', 15, 'Centro', 'Sao Carlos', 'SP', '12345-000', 1950.00, 2, 1);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (9, 'Bastiao', 'Rua Sete', 19, 'Centro', 'Araraquara', 'SP', '98745-000', 6500.00, 2, 6);

insert into Funcionario (numero, nome, rua, nro, bairro, cidade, estado, cep, salario, numeroSupervisor, numeroDepto)
values (10, 'Ricardo', 'Rua 13 de Maio', 55, 'Joquei', 'Sao Paulo', 'SP', '33641-000', 2800.00, 1, 2);

# *************** INSERINDO VALORES NAS TABELAS DEPARTAMENTO **************
insert into Departamento (numero, nome, numeroFuncGer, dataIniGer)
    values (1, 'Financeiro', 1, '2010-08-20');
   
insert into Departamento (numeroFuncGer, numero, nome, dataIniGer)
    values (2, 3, 'Auditoria', '2010-08-20');
   
insert into Departamento (numero, nome, numeroFuncGer, dataIniGer)
    values (4, 'Compras', null, null);
   
insert into Departamento (numero, nome)
    values (5, 'Vendas');
   
insert into Departamento (numero, nome)
    values (6, 'Juridico');

# *************** INSERINDO VALORES NAS TABELAS LOCALDEP **************
#insert into LocalDep(numeroDepto, localizacao) values (1, 'Edificio Marte');

insert into localDep(numeroDepto, localizacao)
values (1, 'Edificio Marte');

insert into localDep(numeroDepto, localizacao)
values (1, 'Edificio Planeta Vermelho');

#insert into localDep(numeroDepto, localizacao)
#values (2, 'Edificio Saturno');

insert into localDep(numeroDepto, localizacao)
values (3, 'Edificio Plutao');

insert into localDep(numeroDepto, localizacao)
values (3, 'Edificio Ex-Planeta');

insert into localDep(numeroDepto, localizacao)
values (4, 'Edificio Jupiter');

insert into localDep(numeroDepto, localizacao)
values (5, 'Edificio Lua');

alter table Dependente change parentescpo parentesco varchar(16);
# *************** INSERINDO VALORES NAS TABELAS DEPENDENTE **************
insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (5, 'Luizinho', '2010-04-02', 'Filho');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (5, 'Mariazinha', '2012-06-06', 'Filha');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (1, 'Julia', '2013-04-02', 'Filha');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (1, 'Ana', '2006-04-03', 'Filha');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (1, 'Maria', '1976-05-03', 'Esposa');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (3, 'Lucas', '1998-11-28', 'Filho');

insert into Dependente (numeroFunc, nome, dataNasc, parentesco)
values (2, 'Joana', '1935-11-28', 'Mae');


# *************** INSERINDO VALORES NAS TABELAS PROJETO **************
insert into Projeto (numero, nome, numeroDepto)
values (1, 'Projeto Serra Leste', 1);

insert into Projeto (numero, nome, numeroDepto)
values (2, 'Projeto Porto Tubarao', 5);

insert into Projeto (numero, nome, numeroDepto)
values (3, 'Projeto sei la', 3);

insert into Projeto (numero, nome, numeroDepto)
values (4, 'Projeto Niquel', 1);

insert into Projeto (numero, nome, numeroDepto)
values (5, 'Projeto COVID', 3);

insert into Projeto (numero, nome, numeroDepto)
values (6, 'Projeto Lava Jato', 5);

insert into Projeto (numero, nome, numeroDepto)
values (7, 'Projeto Serra Pelada', 1);

insert into Projeto (numero, nome, numeroDepto)
values (8, 'Projeto Vale', 3);

# *************** INSERINDO VALORES NAS TABELAS FUNCIONARIOPROJETO **************
insert into FuncProj(numeroFunc, numeroProj, horas)
values(10, 1, '10:45:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (1, 1, '10:45:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (1, 2, '09:25:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (1, 3, '10:15:10');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (2, 4, '20:45:15');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (2, 5, '19:45:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (2, 6, '16:13:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (2, 7, '18:00:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (2, 8, '08:25:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (7, 8, '10:25:00');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (8, 2, '11:22:03');

insert into FuncProj (numeroFunc, numeroProj, horas)
values (10, 4, '21:55:10');
# *************** FIM INSERÇÕES **************

#********consultas**********
select * from Funcionario;
select * from Departamento;
select * from LocalDep;
select * from Projeto;
select * from Dependente;
select * from funcproj;

#<> é o sinal de diferente

#********testes********
select distinct cidade from funcionario;
select nome, cidade, salario / 1000 from funcionario;
select * from funcionario where cidade = 'Valinhos' and salario > 3200;
select funcionario.nome, numeroproj from funcionario, FuncProj where numero = numerofunc;
select * from FuncProj;
select funcionario.nome, numeroproj from funcionario, FuncProj where numero = numerofunc and horas > '30:00:00';
select nome, salario, salario/12 as parcela_13 from funcionario; 				#com a coluna
select nome, salario, salario/12 from funcionario; 								#sem a proxima coluna
select F.nome, numeroproj from funcionario F, FuncProj FP where F.numero = FP.numeroFunc and horas > '30:00:00';
select * from funcionario order by salario asc, nome desc;
select * from funcionario order by salario desc, nome asc;
#select * from funcionario order by salario desc, nome desc;
#select * from funcionario order by salario asc, nome asc;
select salario from funcionario where salario between 2000 and 3000;
select salario from funcionario where salario >= 2000 and salario <= 3000;
select nome from funcionario where rua like '%São Paulo%';
select nome from funcionario where cidade like '%São Paulo%';
select nome, salario from funcionario where nome not like 'Maria%';
select nome, salario from funcionario where nome not like 'Maria %';
select max(salario) as maiorSalario from funcionario; 				#maior salario
select min(salario) as maiorSalario from funcionario; 				#menor salario
select avg(salario) as mediaSalario from funcionario; 				#media dos salarios 
select count(*) as totalFunc from funcionario where salario > 1000; 		#contagens de funcionaros que recebm mais de $1000
select nome, salario from funcionario where salario=(select min(salario) from funcionario);  		#retorna nome e menor salario 
select nome from funcionario where salario is null; 				#nome de pessoas que não recebem salarios
select nome from funcionario where salario is not null; 			#nome de pessoas que recebem salarios
select nome, round(salario,2) from funcionario where salario is not null;
select nome from funcionario F, FuncProj FP where F.numero = FP.numeroFunc and horas = (select max(horas) from FuncProj);   #nome do funcionario que trabalhou mais horas em projetos
select nome from funcionario F, FuncProj FP where F.numero = FP.numeroFunc and horas = (select min(horas) from FuncProj);   #nome do funcionario que trabalhou mais horas em projetos
select nome from funcionario where numero in(select distinct numeroFunc from FuncProj);         #funcionarios com nomes distintos que estao no projeto
select nome from funcionario where numero not in(select distinct numeroFunc from FuncProj);     #funcionarios que não estão em projetos
select nome from funcionario where numero in(select numeroFunc from FuncProj);
select nome from funcionario F, FuncProj P where F.numero = P.numeroFunc;
select nome from funcionario F, FuncProj P where F.numero =  P.numeroFunc and P.horas > all (select distinct horas from funcproj where numeroproj = 2);
select nome from Funcionario F where exists (select * from funcproj FP where F.numero = FP.numeroFunc);
select nome from Funcionario F where not exists (select * from funcproj FP where F.numero = FP.numeroFunc);
select nome from Funcionario F, funcproj FP where F.numero = FP.numeroFunc AND horas in ('08:25:00','43:48:54');

#**********ATIVIDADES*************
#1
select * from funcionario;
#2
select estado from funcionario;
#3
select distinct salario from funcionario;
#4
select nome from funcionario where nome like '%r%';
#5
select f.nome, f.numero from funcionario f, departamento d where f.numero = d.numeroFuncGer;
#6
select f.nome, f.numero, d.dataIniGer FROM funcionario f, departamento d WHERE f.numero = d.numeroFuncGer AND f.salario > 2000 and TIMESTAMPDIFF(YEAR, d.dataIniGer, CURDATE()) >= 3;
#7
select * from funcionario where salario = (select max(salario) from funcionario); 
#8
select p.nome, sum(horas) from projeto p, funcproj f where p.numero = 2 and f.numeroproj = p.numero;
#9
select p.numero, avg(horas) as mediaHoras from projeto p, funcproj f where p.numero = 3 and f.numeroproj = p.numero;
#10
select nome, timestampdiff(year, dataNasc, curdate()) as idade from dependente;
#11
select nome, numero from funcionario where salario > 2200 and cidade = 'São Paulo';
#12
select f.nome, d.nome, d.parentesco from funcionario f, dependente d where f.numero = d.numeroFunc;
#13
select f.nome, p.nome, fp.numeroProj from projeto p, funcionario f, funcproj fp where f.numero = fp.numerofunc;
#14
select f.nome, p.nome, fp.numeroProj, fp.horas from projeto p, funcionario f, funcproj fp where f.numero = fp.numerofunc and fp.horas > '20:00:00';
#15
select * from funcionario order by nome asc;
select * from funcionario order by nome desc;
#16
select * from funcionario order by cidade asc, salario desc;
#17
select nome, salario from funcionario where salario between 1000 and 2000; 
#18
select * from funcionario where cidade like '%ar%';
#19
select nome, salario from funcionario where salario = (select max(salario) from funcionario);
#20
select nome, salario from funcionario where salario = (select min(salario) from funcionario);
#21
select round(avg(salario), 2) from funcionario; 
#22
select round(sum(salario), 2) from funcionario;
#23
select nome, salario, (select COUNT(*) from funcionario where salario > 1500) as quant from funcionario where salario > 1500;
#24
select nome, cidade from funcionario where cidade like 'São%';
#25
select  COUNT(*) from funcionario where salario > (select avg(salario) from funcionario);
#DESAFIO - quais são esses funcionarios e colocar os salarios em ordem asc
select nome, salario from funcionario where salario > (select avg(salario) from funcionario) order by salario asc;
#26
select * from funcionario where numerosupervisor is null;
#27
select * from funcionario where numerosupervisor is not null;
#28
select s.nome, f.nome as nomesupervisor from funcionario f, funcionario s where f.numero = s.numerosupervisor;
#29
select f.nome, fp.horas from funcionario f, funcproj fp where fp.horas = (select max(horas) from funcproj);
#30
select nome from funcionario where numero in (select numerofunc from funcproj);
#31
select nome from funcionario where numero not in (select numerofunc from funcproj);
#32
select f.nome, fp.horas from funcionario f, funcproj fp where f.numero = fp.numerofunc and horas = (select distinct horas from funcproj where numeroproj = 3);


# ----------> JOIN <------------ aula 11
#slide 8
select nome, horas from (funcionario f join funcproj p on f.numero = p.numerofunc)
where horas in ('11:22:03', '10:45:00');

select nome, horas from (funcionario f join funcproj p on f.numero = p.numerofunc)
where horas not in ('11:22:03', '10:45:00');

#slide 11: eles são 'equivalentes' -> o join não retorna nada que é nulo
select nome, numeroproj, horas from (funcionario f inner join funcproj p on f.numero = p.numerofunc);
select nome, numeroproj, horas from funcionario f, funcproj p where f.numero = p.numerofunc;

#slide 13: left join
select nome, numeroproj from (funcionario f left outer join funcproj p on f.numero = p.numerofunc);

#slide 15: right join
select numerofunc, f.nome, numeroproj, p.nome from (funcionario f right outer join funcproj fp on f.numero = fp.numerofunc)
right outer join projeto p on fp.numeroproj = p.numero;

#slide 17: full outer join 
select f.numero AS funcionarioNumero, f.nome as funcionarioNome, p.numero as ProjetoNumero, p.nome as ProjetoNome from funcionario f
left outer join funcproj fp on f.numero = fp.numerofunc
left outer join projeto p on fp.numeroproj = p.numero
union
select f.numero as funcionarioNumero, f.nome as funcionarioNome, p.numero as projetoNumero, p.nome as projetoNome from funcionario f
left outer join funcproj fp on f.numero=fp.numerofunc
left outer join projeto p on fp.numeroproj = p.numero;

#slide 19
select f.numero, f.nome, p.numero, p.nome from 
(funcionario f left outer join funcproj fp on f.numero = fp.numerofunc)
left outer join projeto p on fp.numeroproj = p.numero where
fp.numerofunc is null;

#slide 20
select f.numero, f.nome, p.numero, p.nome from 
(funcionario f right outer join funcproj fp on f.numero = fp.numerofunc)
right outer join projeto p on fp.numeroproj = p.numero where
fp.numerofunc is null;

#slide 21
select f.numero, f.nome, p.numero, p.nome from (funcionario f left outer join 
funcproj fp on f.numero = fp.numerofunc) left outer join projeto p on
fp.numeroproj = p.numero where fp.numeroproj is null
union 
select f.numero, f.nome, p.numero, p.nome from (funcionario f right outer join 
funcproj fp on f.numero = fp.numerofunc) right outer join projeto p on
fp.numeroproj = p.numero where fp.numeroproj is null;

#slide 23 ---> groupy by
select d.nome, d.numero, avg(salario) as media from departamento d, funcionario f 
where d.numero = f.numerodepto
group by f.numerodepto;

#slide 26 ----> sec_to_time
select numerofunc, sec_to_time(sum(time_to_sec(horas))) as total
from funcproj group by numerofunc;

#slide 27 
select * from
(select numerofunc, sec_to_time(sum(time_to_sec(horas))) as total
from funcproj group by numerofunc) as X 
inner join funcionario as f on x.numerofunc = f.numero and 
x.total = (select max(total) from
(select numerofunc, sec_to_time(sum(time_to_sec(horas))) as total 
from funcproj group by numerofunc) B);

#slide 29
select d.nome, d.numero, avg(salario) as media from departamento d, funcionario f 
where d.numero = f.numerodepto
group by f.numerodepto
having media > 2300.00;


# ---------> Exercicios <-----------
#1
select p.nome, p.numero, f.nome from (projeto p right join funcproj fp on 
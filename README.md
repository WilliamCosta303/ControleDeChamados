# AVISO
Projeto hospedado no Gitlab (https://gitlab.com/williamcosta/ControleDeChamados)


# Sistema de controle de chamados de TI
Bem-vindo! Esse código foi o meu projeto de TCC para término do curso Técnico de Informática da QI.
O sistema está 100% funcional com as funções que possui agora (que serão descritas abaixo).

# QA
## Quais os tipos de usuários?
* <b>Usuário</b> - Pode abrir chamados e alterar sua senha;
* <b>Suporte</b> - Pode procurar, capturar, alterar dados, encaminhar, suspender, encerrar chamados; Além de fazer tudo que os usuários podem;
* <b>Administrador</b> - Pode cadastrar usuários no sistema e alterar dados e a equipe de usuários já cadastrados; Além de fazer tudo que o suporte e os usuários podem;

## Quais são os requisitos?
* JAVA 8
* MySQL

## Como faço a v1.0 funcionar?
<b>LEMBRETE: A DISTRIBUIÇÃO É SEMPRE PARA TESTES, POIS A SENHA DO ROOT NÃO É ALGO SEGURO!</b>
Você precisa ter MySQL instalado (eu usava o WampServer para testes), depois altere a senha do 'root' para 123;
No PHPMyAdmin ou direto na shell do MySQL rode o arquivo database.sql do código fonte para criar as tabelas necessárias.

## Esse código poderia ser melhor não?
Claro, por isso estou liberando o código, qualquer ajuda é bem vinda!

# Sistema Hoteleiro Java - Rhitmo


## 📰 Sobre
O Projeto de **Sistema Hoteleiro** é uma API MVC Java com o objetivo de fazer a gestão de reserva dos quartos de um hotel.


## 🚀 Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Lombok](https://projectlombok.org/)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [h2](https://www.h2database.com/html/main.html)

## 💾 Como rodar o projeto

1. Clone do repositório do projeto usando o comando abaixo no seu terminal.
```sh
    > git clone https://github.com/adamsmatheus/AllocationChallenge.git
```

2. O projeto está configurado para possibilitar a criação de uma imagem docker, para isso execute os seguintes passos :
```sh
    > docker build -t hotel-allocation:v3 . 
```
```sh
    > docker run -p 8080:8080 hotel-allocation:v3 
```

Dessa forma subirá a imagem do projeto via docker.
Obs.: Lembrando que é necessário ter o Java 17 na máquina também como o docker.

Com o projeto executando podemos acessar a página inicial do nosso sistema via brownser.
```sh
    > http://localhost:8080/room/list
```

## 📏 Arquitetura do projeto

Para o desenvolvimento dessa API foi levado em consideração dois
fatores muito importantes, o código limpo e a velocidade de resposta. Para deixar
o código menos extenso foi adotado o framework <i>Spring Boot</i> e da biblioteca <i>Lombok</i> onde reduziu
boa parte do código somente adicionando algumas <i>annotations</i>.

A escolha de usar arquitetura em camadas vem pelo razão de ser  amplamente conhecido
e relativamente fácil de ser compreendido. Além disso, o “mindset” de
desenvolvimento tende a especializar etapas de trabalho ou
tecnologias, facilitando a associação com as camadas do projeto.
 
Onde se resultou em uma API com o código fonte
bem pequeno e intuítivo, facilitando bastante o
entendimento.





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

2. Na raiz do projeto procure o pasta ' target ', dentro da mesma execute o SwapCase.jar
```sh
    > > java -jar SwapCase.jar
```

4. Subindo o programa localmente, faça uma requisição e faça um POST para o endereço abaixo.
```sh
    > http://localhost:8080/password
```

5. No Body da mensagem passe um Json, seguindo o exemplo abaixo.
```json
{
      "user":"adamsmatheus",
      "repository":"room",
      "url":"localhost:8080"
}
```
Obs.: Para que o **.jar** rode com sucesso,
você precisa ter o Java 11 instalado na máquina,
caso não tenha clique [aqui](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html).


## 📏 Arquitetura do projeto

<img src="img.jpeg" alt="My cool logo"/>

<img src="diagrama.jpeg" alt="My cool logo"/>

Para o desenvolvimento dessa API foi levado em consideração dois
fatores muito importantes, o código limpo e a velocidade de resposta. Para deixar
o código menos extenso foi adotado o framework <i>Spring Boot</i> onde reduziu
boa parte do código dessa api somente adicionando algumas <i>annotations</i>.

A escolha de usar arquitetura em camadas vem pelo razão de ser  amplamente conhecido
e relativamente fácil de ser compreendido. Além disto, o “mindset” de
desenvolvimento tende a especializar etapas de trabalho ou
tecnologias, facilitando a associação com as camadas do projeto.

Com essas escolhas resultou em uma API com o código fonte
bem pequeno e intuítivo, facilitando bastante o
entendimento.





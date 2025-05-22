# locadora-veiculos-JAVA 

## 🚗 Sistema de Locadora de Veículos em Java
Este projeto implementa um sistema básico de locadora de veículos desenvolvido em Java. Através de uma interface de linha de comando (CLI), o sistema permite interagir com funcionalidades essenciais para a gestão de uma locadora.

## 🔎 O sistema oferece as seguintes funcionalidades:

- Cadastro de Veículos: Permite adicionar novos veículos ao sistema, registrando informações como modelo, placa, ano e valor da diária. O sistema realiza uma validação simples para garantir que a placa não seja duplicada e que o ano e o valor da diária sejam válidos.
- Cadastro de Clientes: Permite registrar novos clientes no sistema, armazenando nome, CPF (com validação de 11 dígitos) e telefone (com validação de 10 ou 11 dígitos).
- Registro de Aluguel: Permite registrar o aluguel de um veículo por um cliente. Para isso, o sistema lista os veículos e clientes cadastrados, solicita a placa do veículo e o CPF do cliente, e então pede a quantidade de dias para o aluguel.
- Listagem de Contratos de Aluguel: Exibe uma lista dos aluguéis registrados no sistema.
- Listagem de Veículos: Exibe uma lista de todos os veículos cadastrados no sistema.
- Listagem de Clientes: Exibe uma lista de todos os clientes cadastrados no sistema.
## 🚀 Estrutura e Tecnologias:

Linguagem: Java
- Entrada/Saída: Console (linha de comando)
- Gerenciamento de Dados: Listas dinâmicas (ArrayList) para armazenar os veículos, clientes e aluguéis em memória.
- Validações: Implementações básicas para CPF (tamanho), telefone (tamanho), placa (unicidade e tamanho), ano do veículo (dentro de um intervalo) e valor da diária (positivo).
- Orientação a Objetos: O projeto demonstra princípios de orientação a objetos através da criação de classes (Veiculos, Clientes, Aluguel - embora o código principal não as detalhe completamente, sua existência é implícita) e da organização do código em métodos com - - responsabilidades específicas.
- Tratamento de Erros: O sistema inclui tratamento básico de erros para entradas inválidas do usuário (por exemplo, ao digitar opções do menu ou dados numéricos).
## 🕹️Como Executar:

- Para executar este sistema, você precisará ter o Java Development Kit (JDK) instalado em seu computador. Após compilar o código fonte (Main.java e possivelmente as classes Veiculos.java, Clientes.java e Aluguel.java), você poderá executar a classe principal Main através da linha de comando.

## 📌 Integrantes envolvidos no projeto:

 - [Maximus Feitoza Lira Cunha](https://github.com/MaxFeitoza)
 - [Leonardo Lucas de Brito Silva](https://github.com/leonardolucasbs)
 
## 📌 fotos da execução do código:
- área de registro dos aluguéis
![area de registro de alugueis](https://github.com/user-attachments/assets/9feb1768-b059-4db6-b9ca-2da401f314b0)
![area de registro de alugueis pt2](https://github.com/user-attachments/assets/14406fd0-6242-446b-bd0e-1000b1de01f7)
- interface
![interface](https://github.com/user-attachments/assets/a8f840c4-ce80-4123-9688-95b52cd7621c)
- contratos
![contratos](https://github.com/user-attachments/assets/2a4b0917-70d3-4df3-87c9-6f4db2187ef5)
- Listagem de Clientes cadastrados
![Clientes cadastrados](https://github.com/user-attachments/assets/228c7d01-ea96-4bed-9c8e-6d2cd85d6d13)
- Listagem de carros cadastrados
![carros cadastrados](https://github.com/user-attachments/assets/b1e8db90-df5b-4620-8273-1e9864fab022)
- cadastros de clientes
![cadastro de clientes](https://github.com/user-attachments/assets/ff532092-fe3a-406b-b4bc-f7b81a478f6c)
- cadastro de carros
![cadastro carros](https://github.com/user-attachments/assets/b62ef998-48c9-4740-aee4-9797a8d814c7)

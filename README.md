# Buscador de CEP

Este é um aplicativo Android simples que permite aos usuários buscar informações de endereço a partir de um CEP (Código de Endereçamento Postal) brasileiro. O aplicativo utiliza a API da [Invertexto](https://www.invertexto.com/) para obter os dados do endereço e gerar um nome de pessoa aleatório.

## Funcionalidades

- **Busca de Endereço por CEP:** Insira um CEP e obtenha o endereço correspondente.
- **Geração de Nome Aleatório:** A cada busca, um nome aleatório é gerado e exibido.
- **Interface Simples:** Uma interface de usuário limpa e intuitiva.

## Tecnologias Utilizadas

- **Linguagem:** [Kotlin](https://kotlinlang.org/) (versão 2.0.21)
- **Arquitetura:** Padrão (Activity)
- **Requisições HTTP:** [Retrofit](https://square.github.io/retrofit/) (versão 2.8.1)
- **Conversor JSON:** [Gson](https://github.com/google/gson) (versão 2.10.1)
- **Java:** Versão 17

## Configuração

Para utilizar este projeto, você precisará de um token de API da [Invertexto](https://www.invertexto.com/).

1.  **Obtenha seu token:** Crie uma conta na [Invertexto](https://www.invertexto.com/) e obtenha seu token de API.
2.  **Configure o token no projeto:**
    *   Crie um arquivo chamado `local.properties` na raiz do projeto.
    *   Adicione a seguinte linha ao arquivo, substituindo `SEU_TOKEN_AQUI` pelo seu token:
        ```properties
        API_TOKEN="SEU_TOKEN_AQUI"
        ```

## Como Usar

1.  Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/android-app-busca-cep.git
    ```
2.  Abra o projeto no Android Studio.
3.  Execute o aplicativo em um emulador ou dispositivo Android.
4.  Insira um CEP no campo de texto e clique em "Buscar".

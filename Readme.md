# Calculadora Parshall
<img width="1024" height="1024" alt="ICON" src="https://github.com/user-attachments/assets/72a94c83-6b36-4710-ab21-31836b2c955a" />


Projeto desenvolvido em Java para realizar o dimensionamento e recomendação de uma Calha Parshall com base na quantidade de habitantes e no consumo médio de água.

O sistema calcula automaticamente a vazão em litros por segundo (L/s), identifica a calha adequada conforme tabelas de referência e apresenta a dimensão recomendada.

---

# Tecnologias Utilizadas

* Java
* IntelliJ IDEA
* Programação Orientada a Objetos (POO)

---

# Estrutura do Projeto

O projeto foi organizado utilizando separação por responsabilidades:

| Classe              | Responsabilidade                            |
| ------------------- | ------------------------------------------- |
| `Controller`        | Controla toda a lógica principal do sistema |
| `View`              | Responsável pela interação com o usuário    |
| `CalhaParshall`     | Modelo com os dados das calhas              |
| `DimensoesParshall` | Modelo das dimensões utilizadas             |
| `Main`              | Inicialização do programa                   |

---

# Funcionalidades

✅ Leitura da quantidade de habitantes

✅ Leitura do consumo médio de água

✅ Cálculo do consumo total diário

✅ Conversão da vazão para litros por segundo

✅ Seleção automática da Calha Parshall adequada

✅ Cálculo da altura hidráulica (Ha)

✅ Recomendação da dimensão final da calha

✅ Validação de entradas do usuário

✅ Possibilidade de realizar múltiplos cálculos

---

# Como Funciona

O usuário informa:

* Quantidade de habitantes
* Consumo médio de água por habitante

O sistema então:

1. Calcula o consumo total diário
2. Calcula a vazão em L/s
3. Busca a Calha Parshall adequada utilizando valores mínimos e máximos
4. Calcula a altura hidráulica utilizando os coeficientes K e N
5. Recomenda a dimensão mais adequada para operação segura

---

# Exemplo de Execução

```bash
Informe a quantidade de habitantes: 5000
Informe o consumo de água por habitante: 180

O consumo total de agua é 900000.00 litros por dia
A vazão de água em litros por segundo é 10.42 L/s

A calha parshall mais adequada é a de 6" Polegadas

Ha (pés): 1.2345
Ha (cm): 37.62
70% de Ha (cm): 26.33

Calha final recomendada: Modelo X
```

---

# Conceitos Aplicados

Este projeto utiliza conceitos importantes de desenvolvimento de software:

* Programação Orientada a Objetos
* Estrutura MVC simplificada
* Encapsulamento
* Validação de dados
* Organização em classes
* Manipulação de listas com `ArrayList`
* Estruturas de repetição e decisão

---

# Objetivo do Projeto

O objetivo do projeto é auxiliar no aprendizado de:

* Desenvolvimento Java
* Estruturação de sistemas
* Separação de responsabilidades
* Aplicação de cálculos hidráulicos
* Desenvolvimento de aplicações de console

---

# Como Executar

## Pelo IntelliJ IDEA

1. Abra o projeto no IntelliJ
2. Localize a classe `Main`
3. Execute o método `main()`

---

# Melhorias Futuras

* Interface gráfica
* Integração com banco de dados
* Exportação de relatórios
* Cadastro de projetos
* Histórico de cálculos
* Geração automática de PDF

---

# Autor

Desenvolvido por 
Felipe Afonso     RA 1985
Franciso Jambers  RA 2043
Alisson Brito     RA 2013
Wesley S.

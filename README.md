# Rota Frete!
 
Aplicativo de estudo feito para aproveitar as melhores práticas de programação usando a APIs públicas de geolocalização e calculo de frete. 

[APK](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/apk/RotaFrete.apk?raw=true) || [VIDEO](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/videos/vide_app_rota_frete.mp4?raw=true) || [YOUTUBE](https://www.youtube.com/watch?v=Ala4heQz7S4)


<table>
  <thead>
    <tr>
      <th>BASE</th>
      <th>Architecture</th>
      <th>IU</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>AppCompact</td>
      <td>DataBinding</td>
      <td>Navigation</td>
    </tr>
    <tr>
      <td>Android KTX</td>
      <td>Lifecycles</td>
      <td>Material Components</td>
    </tr>
     <tr>
      <td>Kotlin</td>
      <td>LiveData</td>
    </tr>
     <tr>
      <td>Android Arch</td>
      <td>ViewModel</td>
    </tr>
  </tbody>
</table>

**Screens**
| **Home** | **Eixo**|**Preço Combustível**|
|--|--|--|
| ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/home.jpeg) | ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/insert_axis.jpeg) |![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/insert_fuel_price.jpeg)|

| Consumo | Ponto de Partida | Ponto de Chegada|
|--|--|--|
| ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/insert_fuel_consumption.jpeg) | ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/insert_start_point.jpeg) | ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/insert_end_point.jpeg)|

|Resumo| Resultado | |
|--|--|--|
| ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/resume.jpeg) | ![enter image description here](https://github.com/hugothomaz/Android-Case/blob/hugo-thomaz/assets/images/result_calc.jpeg) | |


## Base do projeto

- **Multicamada:**
Organização de código inspirada no DDD e na arquitetura limpa focada na escalabilidade da base de código.

- **Injeção de dependência:**
Com o Koin, uma biblioteca prática de injeção de dependências, o código não será associado e ainda será fácil resolver automaticamente as dependências no tempo de execução e zombar delas durante os testes.

- **Kotlin KTS:**
Usando o Kotlin KTS, podemos tirar proveito da configuração do aplicativo usando a linguagem kotlin em nosso arquivo gradle. Isso torna nossa configuração ainda mais fácil

- **Databinding:**
A ligação de dados é uma maneira fácil de controlar as regras da interface do usuário e facilita a ligação de dados na tela. Isso reduz a clichê de código grande e deixa as regras de visualização centralizadas

## Camadas

- ** Presentation: **
Camada para gerenciar o acesso inicial aos dados através do ViewModel

- ** Domain: **
Camada para gerenciar regras de negócios usando eventos de propagação do UseCase

- ** Data: **
Camada para dados de acesso integrado usando Repository e DataSource no banco de dados local ou na nuvem

## CODE
- **IDE - Android Studio 4.0** 

- **Gradle 4.0.0**

- **Kotlin 1.3.72**

- **AAC Android Architecture Components**

- **Clean Architecture**

- **DataBinding**

- **ViewModel**


# Android-Case


## Eu como caminhoneiro gostaria de ter um aplicativo que

- Seja possível inserir uma localização inicial
- Seja possível inserir uma localização final
- Seja possível inserir o número de eixos do meu veículo
- Seja possível inserir o consumo médio de combustível (Diesel) do meu veículo
- Seja possível inserir o valor atual do Diesel
- Que o aplicativo calcule a rota entre o ponto inicial e o ponto final
- Que o aplicativo disponibilize dados sobre a duração da viagem, número de pedágios, valor mínimo do frete baseado na tabela da ANTT para diferentes tipos de carga

## O que deve conter nesse aplicativo : 

- Permitir que o usuário informe o número de eixos do caminhão dele ( mínimo 2, máximo 9)
- Permitir que o usuário informe o valor de consumo médio (Km/litro) de combustível(diesel)
- Permitir que o usuário escolha a sua origem
- Permitir que a origem seja capturada pelo gps do dispositivo
- Permitir que o usuário escolha um destino
- Exiba o resultado da api para o usuário
- Se possível, permitir que usuário tenha acesso a seu histórico de buscas de rotas e valores

## Orientações para a construção do case:

Nós da TruckPad temos uma API que disponibiliza os dados sobre rotas, preços, números de pedágios, consumo médio de combustível e outras coisas que permeiam a rotina do nosso usuário final, o caminhoneiro. Todos os dados que são requiridos na aplicação são disponibilizados por nossas APIS

Temos o nosso site [Recalcula Frete](https://www.recalculafrete.com.br/) que pode ser usado de apoio para a implementação do case.

Apis de Apoio:

- [https://geo.api.truckpad.io/v1/route](https://geo.api.truckpad.io/v1/route)

Retorna informações sobre distância, tempo de viagem, consumo de combustível, custo total da viagem e  número de pedágios.

Exemplo de um request :
```json 
POST https://geo.api.truckpad.io/v1/route
{
    "places": [{
        "point": [
            -46.68664,
            -23.59496
        ]
    },{
        "point": [
            -46.67678,
            -23.59867
        ]
    }],
    "fuel_consumption": 5,
    "fuel_price": 4.4
}
```
Exemplo de resposta ->

```json 
RESPONSE - > {
    "points": [
        {
            "point": [
                -46.68664,
                -23.59496
            ],
            "provider": "Provided"
        },
        {
            "point": [
                -46.67678,
                -23.59867
            ],
            "provider": "Provided"
        }
    ],
    "distance": 1962,
    "distance_unit": "meters",
    "duration": 583,
    "duration_unit": "seconds",
    "has_tolls": false,
    "toll_count": 0,
    "toll_cost": 0,
    "toll_cost_unit": "R$",
    "route": [
        [
            [
                -46.68662,
                -23.59504
            ],
            [
                -46.6881,
                -23.59571
            ],
            [
                -46.68701,
                -23.59613
            ],
            [
                -46.68546,
                -23.59575
            ],
            [
                -46.67528,
                -23.60051
            ],
            [
                -46.67486,
                -23.59966
            ],
            [
                -46.6768,
                -23.59871
            ]
        ]
    ],
    "provider": "Maplink",
    "cached": true,
    "fuel_usage": 0.39,
    "fuel_usage_unit": "liters",
    "fuel_cost": 1.73,
    "fuel_cost_unit": "R$",
    "total_cost": 1.73
} 
```
Após pegar os dados da rota, usamos outra api para calcular o preço por alguns tipos de carga que mais utilizamos em nossa plataforma
- [ https://tictac.api.truckpad.io/v1/antt_price/all]( https://tictac.api.truckpad.io/v1/antt_price/all)

```json 
POST - https://tictac.api.truckpad.io/v1/antt_price/all
{"axis":2,"distance":2976.087,"has_return_shipment":true}
```
```json
RESPONSE - > {
    "frigorificada": 3987.96,
    "geral": 5654.57,
    "granel": 5595.04,
    "neogranel": 5059.35,
    "perigosa": 3571.3
}
```

## Instruções para a realização do case 
- Faça um **fork** desse repositório;
- Crie uma **branch** com o **seu nome**;
- Depois que terminar suas implementações, faça um **Pull Request** para o branch **master**;

## Recomendações para a realização do case
- O código poderá ser feito em Java, mas será um diferencial se você realizar ele em Kotlin
- Testes unitários não são obrigatórios, mas será um diferencial se o projeto conter testes
- Sugerimos usar algum tipo de arquitetura ( MVVM, MVP, MVI ou qual você achar melhor)
- Nós da TruckPad estaremos a disposição em caso de dúvidas, então não deixe de nos contactar

Boa sorte
 


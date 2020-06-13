# Rota Frete!

Aplicativo de estudo feito para aproveitar as melhores práticas de programação usando a API pública da marvel Mostra informações como séries, personagens, eventos e quadrinhos


# Files

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**

## Create files and folders

The file explorer is accessible using the button in left corner of the navigation bar. You can create a new file by clicking the **New file** button in the file explorer. You can also create folders by clicking the **New folder** button.

## Switch to another file

All your files and folders are presented as a tree in the file explorer. You can switch from one to another by clicking a file in the tree.

## Rename a file

You can rename the current file by clicking the file name in the navigation bar or by clicking the **Rename** button in the file explorer.

## Delete a file

You can delete the current file by clicking the **Remove** button in the file explorer. The file will be moved into the **Trash** folder and automatically deleted after 7 days of inactivity.

## Export a file

You can export the current file by clicking **Export to disk** in the menu. You can choose to export the file as plain Markdown, as HTML using a Handlebars template or as a PDF.


# Synchronization

Synchronization is one of the biggest features of StackEdit. It enables you to synchronize any file in your workspace with other files stored in your **Google Drive**, your **Dropbox** and your **GitHub** accounts. This allows you to keep writing on other devices, collaborate with people you share the file with, integrate easily into your workflow... The synchronization mechanism takes place every minute in the background, downloading, merging, and uploading file modifications.

There are two types of synchronization and they can complement each other:

- The workspace synchronization will sync all your files, folders and settings automatically. This will allow you to fetch your workspace on any other device.
	> To start syncing your workspace, just sign in with Google in the menu.

- The file synchronization will keep one file of the workspace synced with one or multiple files in **Google Drive**, **Dropbox** or **GitHub**.
	> Before starting to sync files, you must link an account in the **Synchronize** sub-menu.

## Open a file

You can open a file from **Google Drive**, **Dropbox** or **GitHub** by opening the **Synchronize** sub-menu and clicking **Open from**. Once opened in the workspace, any modification in the file will be automatically synced.

## Save a file

You can save any file of the workspace to **Google Drive**, **Dropbox** or **GitHub** by opening the **Synchronize** sub-menu and clicking **Save on**. Even if a file in the workspace is already synced, you can save it to another location. StackEdit can sync one file with multiple locations and accounts.

## Synchronize a file

Once your file is linked to a synchronized location, StackEdit will periodically synchronize it by downloading/uploading any modification. A merge will be performed if necessary and conflicts will be resolved.

If you just have modified your file and you want to force syncing, click the **Synchronize now** button in the navigation bar.

> **Note:** The **Synchronize now** button is disabled if you have no file to synchronize.

## Manage file synchronization

Since one file can be synced with multiple locations, you can list and manage synchronized locations by clicking **File synchronization** in the **Synchronize** sub-menu. This allows you to list and remove synchronized locations that are linked to your file.


# Publication

Publishing in StackEdit makes it simple for you to publish online your files. Once you're happy with a file, you can publish it to different hosting platforms like **Blogger**, **Dropbox**, **Gist**, **GitHub**, **Google Drive**, **WordPress** and **Zendesk**. With [Handlebars templates](http://handlebarsjs.com/), you have full control over what you export.

> Before starting to publish, you must link an account in the **Publish** sub-menu.

## Publish a File

You can publish your file by opening the **Publish** sub-menu and by clicking **Publish to**. For some locations, you can choose between the following formats:

- Markdown: publish the Markdown text on a website that can interpret it (**GitHub** for instance),
- HTML: publish the file converted to HTML via a Handlebars template (on a blog for example).

## Update a publication

After publishing, StackEdit keeps your file linked to that publication which makes it easy for you to re-publish it. Once you have modified your file and you want to update your publication, click on the **Publish now** button in the navigation bar.

> **Note:** The **Publish now** button is disabled if your file has not been published yet.

## Manage file publication

Since one file can be published to multiple locations, you can list and manage publish locations by clicking **File publication** in the **Publish** sub-menu. This allows you to list and remove publication locations that are linked to your file.


# Markdown extensions

StackEdit extends the standard Markdown syntax by adding extra **Markdown extensions**, providing you with some nice features.

> **ProTip:** You can disable any **Markdown extension** in the **File properties** dialog.


## SmartyPants

SmartyPants converts ASCII punctuation characters into "smart" typographic punctuation HTML entities. For example:

|                |ASCII                          |HTML                         |
|----------------|-------------------------------|-----------------------------|
|Single backticks|`'Isn't this fun?'`            |'Isn't this fun?'            |
|Quotes          |`"Isn't this fun?"`            |"Isn't this fun?"            |
|Dashes          |`-- is en-dash, --- is em-dash`|-- is en-dash, --- is em-dash|


## KaTeX

You can render LaTeX mathematical expressions using [KaTeX](https://khan.github.io/KaTeX/):

The *Gamma function* satisfying $\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N$ is via the Euler integral

$$
\Gamma(z) = \int_0^\infty t^{z-1}e^{-t}dt\,.
$$

> You can find more information about **LaTeX** mathematical expressions [here](http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference).


## UML diagrams

You can render UML diagrams using [Mermaid](https://mermaidjs.github.io/). For example, this will produce a sequence diagram:

```mermaid
sequenceDiagram
Alice ->> Bob: Hello Bob, how are you?
Bob-->>John: How about you John?
Bob--x Alice: I am good thanks!
Bob-x John: I am good thanks!
Note right of John: Bob thinks a long<br/>long time, so long<br/>that the text does<br/>not fit on a row.

Bob-->Alice: Checking with John...
Alice->John: Yes... John, how are you?
```

And this will produce a flow chart:

```mermaid
graph LR
A[Square Rect] -- Link text --> B((Circle))
A --> C(Round Rect)
B --> D{Rhombus}
C --> D
```


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
 


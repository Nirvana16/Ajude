**ATENÇÃO:

1)BUGS CONHECIDOS: 

  1.1)Ao iniciar o Android o serviço do Ajude é incializado, porem apresenta uma mensagem de erro informando que o serviço parou, ainda não corrigi o problema, 
      mas, aparentemente, não afeta nenhuma outra funcionalidade do aplicativo até o momento
      
  1.2)No primeiro uso será solicitada a permissão para recebimento e envio de SMS, caso o usuario demore muito para escolher uma opção o programa irá iniciar sem
      a liberação o que irá impedir o envio e recebimento de mensagens. (Basta fechar e abrir o app e aprovar a permissão para contornar esse problema)

    OBSERVAÇÃO:
            É possivel conceder as permissões necessárias indo nas informações do Aplicativo
            (Configurações / Aplicações / AJUDE) E informar as permissões na proxima tela.

2)O que foi realizado até o momento no ramo Master:

    - Criado Activities.
    - Implementado Layout.
    - Populado os Forms das Activities com dados ilustrativos
    - Implementado as Transições, chamadas, entre uma Activity e outra em todas as Activities.
    - Implementado Action Bar na tela principal e na Tela medicamentos
    - Iniciado o desenvolvimento da Função principal de enviar a mensagem de alerta.
    - Iniciado o desenvolvimento da Classe Serviço que ira receber o alerta e disparar um Alarme sonoro e visual (SMS com 123)
    - Relizado a execução do servico em segundo plano, mesmo que o App não tenha sido executado pelo usuario.
    - Iniciado a realização da documentação do App
    - Realizado o Diagrama de Classes
    - Realizado xml dos botões com efeito de animação ao clique.
    - Implementado a persistencia com SugarORM na Classe MENSAGEM
    - Implementado CRUD na classe Medicamento 
    
2.1) O que falta ser realizado:

    - Polir as Activities para melhor efeito visual
    - Implementar O CRUD com Sugar nas outras classes
    - Finalizar a documentação.
    - Realizar o restante da parte de programação do projeto.
    - Implemenntar o serviço de geolocalização
    
    
IFF - Campus Centro Bacharelado de Sistemas de Informações Projeto Orientação a Objetos Aplicada
SISTEMA DE APOIO EMERGENCIAL UTILIZANDO A PLATAFORMA ANDROID. .

.INTRODUÇÃO Observando o crescimento da utilização de aplicativos móveis pela população idosa, assim como a elevação dos indicies de violência essa aplicação surge com o objetivo de auxiliar seus utilizadores, principalmente os da terceira idade, a manterem seu sentimento de segurança e independência.

.OBJETIVOS Esta aplicação visa fornecer suporte rápido a qualquer pessoa que, porventura, encontra-se em uma situação de risco. Por meio de um simples apertar de um botão em um smartphone. Bem como prover maior autonomia e comodidade a pessoas que fazem uso de medicação periódica.

.OBJETIVOS ESPECÍFICOS O Aplicativo permitirá: • Avisar imediatamente parentes e amigos do utilizador que ele necessita de uma ajuda. • Enviar informações como geolocalização do utilizador. • Acionar um alarme sonoro no disposto. • Enviar mensagens recorrentes automáticas com a localização do usuário. • Cadastrar medicação a qual o usuário esteja utilizando. • Cadastrar datas de próximos exames e consultas a serem realizadas pelo paciente

Documentação completa: Vide diretório de documentação. 

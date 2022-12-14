   ALTERADO
  # behavioral-patterns

Objetivo do repositório é apenas armazenar códigos de treinamentos da Alura.

Padrões de projeto são soluções genéricas para problemas recorrentes do desenvolvimento de software orientado a objetos;

Existem três principais categorias de padrões de projeto:
* Comportamentais (que serão vistos neste treinamento)
* Estruturais
* Criacionais

Objetivos de aplicar os padrões</br>
* Não repita código com Template Method
* Saiba da importância de estudar os padrões de projeto
* Resolva problemas de muito ifs usando Strategy
* Adicione comportamentos ao seu objeto com Decorator
* Crie diferentes ações com Observer
* Use o Builder para a criação de objetos complicados

Padrões **comportamentais**
* Strategy
* Chain of Responsability
* Template Method
* State
* Command
* Observer
  FONTE: https://cursos.alura.com.br/course/introducao-design-patterns-java

Padrões **Estruturais**
* Adapter
* Decorator
* Composite
* Facade
* Proxy
  FONTE: https://cursos.alura.com.br/course/avancando-design-patterns-java

#### Strategy:
    Como diminuir a complexidade do nosso código, trocando múltiplas condicionais por classes

    Que tipo de problema o padrão Strategy visa resolver?
    Este padrão pode ser utilizado quando há diversos possíveis algoritmos para uma ação (como calcular imposto, por exemplo).
    Outro exemplo seria: calcular custo ou tempo de uma viagem de carro, ônibus ou avisão
    Nele, nós separamos cada um dos possíveis algoritmos em classes separadas.

##### Muitos IFs:
     Diversos if podem ser um problema, e que ter uma classe que "pode crescer para sempre" também é um problema.
        
     Sempre que uma nova funcionalidade for implementada, o ideal é que possamos criar código novo e editar o 
     mínimo possível de código já existente.
     Este é um dos principais pontos do princípio Aberto-Fechado (Open-Closed Principle) do SOLID. 
     Ao editar código existente, podemos acabar quebrando funcionalidades já implementadas e funcionais.

#### Chain of Responsability:
    Que tipo de problema o padrão Chain of Responsability visa resolver?

    Diferente do Strategy, aqui eu não sei de cara o que quero aplicar.
    Então precisamos verificar para cada tipo de ação se devemos aplicar ou não.
    Então o primeiro tipo/etapa sabe se aplica ou passa para a próxima, vamos escalando o processo até a etapa final.

#### Template Method
    Que tipo de problema o padrão Chain of Responsability visa resolver?
    O padrão Template Method favorece o reaproveitamento de códigos comuns entre classes,
    evitando assim duplicações de códigos.

    Criação de um método concreto na classe “mãe”,
    que chama métodos abstratos implementados nas classes “filhas”.
    Entao temos o "Metodo Modelo" que faz parte do template, mas outras partes ele delega!

#### State
    State resolve um problema parecido com o Strategy, evitamos muitos IFs
    utilizado em transição de estado ou aplicar regra baseado em um status.
    também utilizado em regras de transições de estados.

    O Objeto pode se comportar de forma diferente conforme seu estado.
    podemos delegar a ação para uma classe específica do estado atual.

#### Command
    Utilizado em aplicacoes que podem ter várias ações(salvar, enviar email etc...)
    A extração do caso de uso para uma classe, pode ser chamda de padrão command.
    tem como Responsabilidade orquestrar tarefas a serem executadas. 

    Recebendo os dados e executando todas as tarefas no mesmo local, evitamos duplicacao de codigo
    e podemos reaproveitar a logica independente de qual caminho (api rest/input cmd/fila) for utilizado.
    evitando duplicar o código em vários lugares.

    Padrões de DDD e Clean Architecture utilizam bastante o Command Handle

    Separando em classes menores facilita a depuração.
    Se o banco ou envio de email mudar o nosso command handle não precisa saber
    então cada classe deve ser responsavel por uma pequena tarefa.

#### Observer
    A ideia e ter ouvintes ou observadores que quando ela for chamada executa a acao
    entao a classe que dispara o evento tem a lista de observadores, ouvintes.
    Evitamos varias chamadas de varias classes, invertendo controles, e deixando as classes
    notificadas responsaveis por realizar a acao.
    Aplicando Inversao de controle e Injecao de dependencias deixamos a class mais coesa.

#### Adapter
    Visa fazer uma adaptação de comunicação
    Ex: Um adaptador como um T ou tomada de 3 pinos que pode ter diferentes tipos
    assim nosso adaptador esta preparado para diferentes tipos.
    Uma ponte entre a sua classe e o mundo externo.
    Assim usando o T não precisamos arrumar a tomada ou cortar o terceiro pino do carregador.

#### Decorator
    Adicionar comportamentos em tempo de execução.
    Um objeto é composto por ele mesmo alterando o seu comportamento
    No nosso caso temos um imposto ICMS que podemos compor, ou decorá-lo com +1 
    Imposto que é o ISS, juntando em um novo cálculo.
    Como se fosse uma árvore-de-natal com decorações. Ex, vamos colocar uma estrela no topo
    ou vamos colocar um pisca-pisca, assim a árvore continua arvorar, mas com novas características.
    
    O Objetivo é não alterar o codigo e regras existentes
    permite adicionar novos comportamentos a um objeto, tornando o código bastante flexível e dinâmico.
    
    Obs: é comum de ser implementado, possui a mesma interface do objeto que ele está decorando.
    Outro exemplo de utilizacao é quando precisamos implementar notificacoes em diferentes plataformas
    Ex: SMS, Facebook, Slack, Whastapp. 

#### Composite
    Irmão do decorator, como strategy é irmão do state.
    Diferente do decorator que decora de forma dinamica para alterar valores
    (add em tempo de execucao)
    no composite a gente compões objetos, basicamente estamos compondo como se fosse 
    uma estrutura de arvore.
    
    Ex: Ao implementar uma interface que permita representar ItemOrcamentos 
    e Orcamentos de forma semelhante, podemos percorrer essa lista de Orcavels facilmente, 
    para calcular o valor do orçamento, que é a raiz da árvore.

#### Facade
    Quando temos um processo que envolve várias etapas, classes chamadas de métodos
    ao invés de expor a complexidade para o cliente (cliente deve saber quais métodos chamar, ordem de execução dos métodos etc...)
    ele simplesmente chama uma fachada.
    Um método que encapsula e abstrai, livrando o cliente desses detalhes internos.
    Melhoramos o acoplamento e não estamos expõe particularidades da classe.

 ``` java
Exemplo: Imagine um processo de transferência de valor entre duas contas.
o cliente teria todo o trabalho de sempre realizar todos os passos e ordem
(executar fora de ordem pode dar problema) dessa forma a interface expões detalhes
o mais fácil seria criar uma classe FACADE escondendo os detalhes.
Ex: Classe A chama a B, C, D.
     
    Conta minhaConta = new Conta();
    Conta outra = new Conta();
    BigDecimal valorTransferencia = new BigDecimal("100");
    
    Transferencia transferencia = new Transferencia();
    transferecia.validarConta(minhaConta);
    transferecia.validarConta(outra);
    transferecia.checarSaldo(minhaConta, valorTransferencia);
    
    transferecia.executar(minhaConta, outra, valorTransferencia);
    //o ideal seria deixar toda a logica de transferencia dentro do executar.    
 ```


#### Simplificando SOLID
Padrões convém com princípios SOLID: Objetivo escrever códigos mais limpos na POO
* S - Princípio da responsabilidade única (Single Responsibility Principle)
* O - Princípio Aberto-Fechado(Open Closed Principle)
* L - Princípio da substituição da Liskov (Liskov Substituition Principle)
* I - Princípio da Segregação da Interface (Interface Segregation Principle)
* D - Princípio de inversão de dependências (Dependency Invesrion Principle)


##### SRP — Classe métodos, funções, devem ter apenas uma tarefá, um objetivo, um assunto, uma responsabilidade.

    Problemas: 
    Assim evitamos as famosas GOD Class: classes com muitas responsabilidades.
    Baixa Coesão: uma classe não pode assumir responsabilidades além das suas.
    Alto Acomplamento: Quanto mais responsável a classe for mais dependências ela terá.
    Mocks: Seguindo o SRP ficam mais fáceis os testes de unidade ou de integração.
    Dificuldades de reaproveitamento de código.

###### Exemplos de Implementação:
Poderíamos separar classes de repository.

    OrdemService: (com funções/metodos de save,delete,find,update)
    OrdemConsultaRepository(apenas funções/metodos de consultas)
    OrdemRepository(Funções de save/update/delete)

##### OCP — Aberto para extensão mas Fechado para alteração.
Caso exista a necessidade de uma nova funcionalidade, devemos estender e não alterar códigos já existentes.

    Ex: Caso você tenha uma classe com 2 IF, para decidir qual pagamento  1 para PJ outro para CLT
    e se surgir uma nova regra, deveríamos incluir mais um IF seriam 3 IFs.
    Problema: alterar algo já existente, abre margem para inclusão de bugs.

###### Solução: Uncle Bob:
    Separe os comportamentos extensíveis por trás de uma interface e inverta as dependências.


###### Implementação:
    criar uma interface com uma função
    Ex: pagamento() e criar classes uma para cada IF, que implementam a interface, 
    obrigando a implementação da função pagamento, assim a classe que processa os pagamentos,
    vai ter apenas uma linha e não 3 IFs, a linha irá verificar qual tipo de pagamento deve ser 
    realizado com base nas condições dos IFs, que estão agora dentro de suas próprias classes e não mais dentro de IF.


##### LSP — Liskov Substitution Principle (Barbara Liskov 1987)
Definição particular para o conceito de subtipo.


    Se para cada objeto o1 do tipo S há um objeto o2 do tipo T
    de forma que, para todos os programas P definidos em termos de T
    o comportamento de P é inalterado quando o o1 é substituído por o2
    então S é um subtipo de T.

###### Exemplo:
Podemos passar como param , tanto a classe pai como a classe derivada.

    Temos a classe Usuario e a classe Pessoa que extends Usuario 
    ambas com método getName()
    caso exista uma função que receba como param o objeto Usuario e imprima o nome
    tanta a Pessoa quanto o Usuario podem ser passados como param
    pois Pessoa é Herança de Usuario.

###### Violações do LSP:
Para evitar essas violações, é necessário estruturar bem as abstrações.
Podemos usar Injeções de dependências e outros princípios SOLID.

    Sobrescrever/implementar métodos que não fazem nada;
    Lançar uma exceção inesperada;
    Retornar valores de tipos diferentes da classe Pai;

##### ISP — Interface Segregation Principle:
Não podemos forçar uma classe a implementar interfaces e métodos que ela não vá utilizar.

###### Exemplo:
Criar interfaces mais específicas, ao invés de uma genérica.

    Temos uma Interface Aves que abstrai comportamento de Animal
    Caso um Pinguim implemente Aves, ele será obrigado a implementar o método
    setAltitude(altitude: number) e pinguins não voam, violamos o ISP =/ 

###### Solução:
    Podemos resolver da seguinte forma:
    Devemos criar uma interface mais específica. 
    interface AvesQueVoam extends Aves
    e a interface AvesQueVoam, essa sim! vai ter a funcao setAltitude(altitude: number)
    assim o pinguim, pode ser uma Ave mas não precisa implementar o setAltitude
    pois o setAltitude faz parte das AvesQueVoam.

##### DIP — Dependency Inversion Principle:
Dependa de abstração e não de implementações.

    Uncle Bob: 
    Modules de alto nível não devem depender de módulos de baixo nível 
    ambos devem depender de abstrações
    
    Abstrações não devem depender de detalhes,
    detalhes devem depender de abstrações.

**Inversão de Dependência é Diferente de Injeção de Dependêcia.**

**Mas estão relacionadas.**

    Inversão de Dependência é um princípio.
    Injeção de Dependência é um Design Patterns.

###### Exemplo:

``` java
use MySQLConnection;

class PasswordReminder
{
    private $dbConnection;
    
    public function __construct()
    {       
        $this->dbConnection = new MySQLConnection();           
    }
    
    // Faz alguma coisa
}
```

    Para recuperar senha, a class precisa conectar no banco de dados, então toda a vez que ela for instanciada, 
    ela automaticamente cria uma new MySQLConnection no construtor.
    
    Ocasionando um alto nível de acoplamento, a classe Reminder, tem a responsabilidade de criar uma instância da classe
    connection, então se reaproveitarmos a classe, automaticamente teríamos que levar a MySQLConnection junto.

###### Solução:

    Passar como param a connection, assim realizamos a injeção de dependência
    e melhorando o nível de acoplamento mas ainda viola a inversão de dependência.
    Também viola o Open Closed Principle, se precisar alterar o banco Mysql para Oracle
    teríamos que alterar a classe.
    
    Estamos dependendo de uma implementação e não abstração =/
``` java
public function __construct(MySQLConnection $dbConnection)
{       
    $this->dbConnection = $dbConnection;           
}
```
    A class Reminder depende da Connection, sendo assim a reminder é um module de alto nível 
    e Connection é um module de baixo nível, então para refatorar:
    Precisamos criar uma interface 

``` java
interface DBConnectionInterface
{
    public function connect();
}
```

    E passar como param na Reminder a interface (abstração proposta por interface)

``` java
public function __construct(DBConnectionInterface $dbConnection) {
    $this->dbConnection = $dbConnection;
}
```
    Assim cada class connection pode implementar a interface e obrigatoriamente
    o metodo connect assim, ambas classes de connection Mysql e Oracle 
    serão desacopladas e dependendo de uma abstração, favorecendo a reutilização
    e respeitando o SRP e OCP.

Referência: https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530    
    
    


# arquitetura-software
Repositório para disciplina de Arquitetura de Software da UTFPR-CP, referente à 2020/2.
<h1> Atividade 3 </h1>
<p> Primeiramente foi realizada a avaliação do código referente ao commit <a href="https://github.com/isabelanunes/arquitetura-software/commit/2fdb64c843dbc837e275ebeb6fedc17b97fb9643"> 2fdb64c</a>. </p>
<h2> I. Contagem de linhas, utilizando o <a href= "https://github.com/AlDanial/cloc"> cloc</a>. </h2>
<pre>
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            11            144             95            600
XML                              9              0              0            397
Maven                            1              7              1             21
-------------------------------------------------------------------------------
SUM:                            21            151             96           1018
-------------------------------------------------------------------------------
</pre>

<h2> II. Quantidade de Estruturas Condicionais </h2>
<pre>
--------------------------------
ESTRUTURAS CONDICIONAIS:      5
--------------------------------
</pre>
<h2> III. Quantidade de Pontos a Realizar Melhoras </h2>
<ul>
<li> Revisar a clareza dos nomes das variáveis, métodos e classes; </li>
<li> Analisar a viabilidade de utilização de <b>interface</b> e <b>polimorfismo</b> para as classes que implementam métodos semelhantes ✓ </li>
<li> Analisar classes e variáveis que devem ser <b><i> final</i></b> ✓ </li>
<li> Analisar a viabilidade de reduzir a quantidade de estruturas condicionais ✓</li>
</ul>

<p> <b> Commit <a href="https://github.com/isabelanunes/arquitetura-software/commit/8b2491dc905284cdd6ec6ea2a9664a8e5ba810ca">8b2491d</a> </b> </p>
<ul>
  <li> Adequação ao <a href="https://refactoring.guru/pt-br/design-patterns/strategy">Design Patterns Strategy</a> </li>
    <p>Criação de interfaces FonteElemento, implementada nas classes FonteFosforo e FontePotassio, e interface CorrecaoElemento, implementada nas classes CorrecaoFosforo e CorrecaoPotassio. <br>
O objetivo desta adequação é criar uma interface com os métodos utilizados em comum pelas classes, visto que possuem a mesma assinatura. Dessa forma, quando os métodos de Correcao dos outros elementos forem implementados, já existe os métodos que devem ser obrigatoriamente implementados, devido a utilização da interface.
Este padrão de código foi útil, em conjunto com a classe enum, para diminuir a quantidade de estruturas condicionais que haviam no inicio no projeto. E ainda, o padrão pode ser replicado conforme a necessidade do código, facilitando a manutenabilidade. </p> </li>
<p>
  <li> Utilização de operador ternário </li>
  <p> Os operadores ternários foram utilizados para eliminar as estruturas condicionais. Cada estrutura condicional que possuia 4 linhas pode ser implementada em apenas uma linha.</p>
  <li> Modificador de acesso <i> final </i> </li>
  <a href="https://www.devmedia.com.br/modificadores-de-acesso-do-java/27065">Referência </a>
</ul>
  <br>
  <p> <b> Métricas </b> </p>
<pre>
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            13            136            110            623
XML                              9              0              0            397
Markdown                         1              1              0             30
Maven                            1              7              1             21
-------------------------------------------------------------------------------
SUM:                            24            144            111           1071
-------------------------------------------------------------------------------
</pre>
<pre>
--------------------------------
ESTRUTURAS CONDICIONAIS:      0
--------------------------------
</pre>

<p> <b> Commit <a href="https://github.com/isabelanunes/arquitetura-software/commit/c828f7e19bd5a9fe8d7cbc3c26ef1f7c6146172c">c828f7e</a> </b> </p>
<ul>
  <li> Alteração da designiação e atribuição das variáveis de retorno do método "correcaoFornece()" </li>
  <p>Com essa mudança foi possível reduzir 3 linhas de código para apenas uma, que faz a atribuição do array diretamente na linha de retorno.</p>
  <li> Exclusão das variáveis auxiliares dos métodos de teste </li>
  <p>As variáveis auxiliares foram instanciadas diretamente no método do assertEquals. Foram mantidas somente as variáveis fixas, utilizadas mais de uma vez na classe de teste. 
  <br> Essa alteração otimizou o código, excluindo a etapa de designação com a criação e instaciação de variáveis ao longo do código. </p>
</ul>
<p> <b> Métricas </b> </p>
<pre>
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            13            135            110            529
XML                              9              0              0            397
Markdown                         1              1              0             30
Maven                            1              7              1             21
-------------------------------------------------------------------------------
SUM:                            24            143            111            977
-------------------------------------------------------------------------------
</pre>

<pre>
--------------------------------
ESTRUTURAS CONDICIONAIS:      0
--------------------------------
</pre>

<p> Como visto, as decisões tomadas ao longo do desenvolvimento desta atividade impactaram positivamente a otimização do código e, por conseguinte, a manutenabilidade do mesmo. </p

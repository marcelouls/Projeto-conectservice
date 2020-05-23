<?php
session_start();


require_once('db.class.php');



$nome   = $_POST['nome'];
$senha  = md5($_POST['senha']);
$fone   = $_POST['fone'];
$funcao = $_POST['funcao'];

$usuario_ativo = $_SESSION['nome_usuario'];


$objDb = new db();
$link = $objDb-> conecta_mysql();

$usuario_existe = false;


// verificar se o usuario ja existe
$sql = " select * from usuarios where nome_usuario = '$nome' ";


if ($resultado_id = mysqli_query($link, $sql)) {

	$dados_usuarios =mysqli_fetch_array($resultado_id);
	//var_dump($dados_usuarios);
	if(isset($dados_usuarios['nome_usuario'])){
		$usuario_existe = true;
		}
}else{
	echo 'erro ao tentar localizar o registro de usuario';
}

// verificar se o usuario ja existe

if ($usuario_existe ) {

	$retorno_get = '';

	if ($usuario_existe) {

		$retorno_get.="erro_usuario=1&";
	}

	
	header('Location: home.php?'.$retorno_get);
	die();
	
}


mysqli_query($link, $sql);
$sql = " insert into usuarios(nome_usuario, rol_usuario, senha_usuario,fone_usuario, usuario_registro) values(upper('$nome'), $funcao, '$senha', '$fone', upper('$usuario_ativo'));" ;
// executar a query
//var_dump($sql);




?>
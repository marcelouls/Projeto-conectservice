<?php

session_start();

require_once('db.class.php');

$nome_usuario =  $_POST['nome_usuario'];
$senha_usuario =  md5($_POST['senha_usuario']);


 
$sql = " SELECT  nome_usuario,senha_usuario FROM usuarios WHERE nome_usuario = '$nome_usuario' AND senha_usuario = '$senha_usuario' ";


$objDb = new db();
$link = $objDb-> conecta_mysql();

$resultado_id = mysqli_query($link, $sql);



if ($resultado_id) {
	$dados_usuario = mysqli_fetch_array($resultado_id);
	var_dump($resultado_id);
	
	if(isset($dados_usuario['nome_usuario'])){
		$_SESSION['nome_usuario'] = $dados_usuario['nome_usuario'];
		header('Location: home.php');
}else{
		header('Location: index.php?erro=1');

}
}else{
	echo 'Erro na execucao da consulta, entrar em contato com adm do site';

} 



?>
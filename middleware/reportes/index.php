<?php

	// SOAP REPORTES

	$operacion = $_GET["operacion"];
	
    try{
		$wsdl_url = 'http://localhost:8080/JAXWS-SSDD/reportes?wsdl';
		
        $soapClient = new SOAPClient($wsdl_url);
		
		# OPERACION traerHistorialAcademicoPorEstudiante
		if($operacion == "traerHistorialAcademicoPorEstudiante"){
			
			$idUsuario = $_GET["idUsuario"];
			$data = null;
			
			$parametros = array(
				'idUsuario' => $idUsuario,
			);

			$estudianteWS = $soapClient->traerEstudianteConCarrera($parametros);
			$historialAcademicoWS = $soapClient->traerHistorialAcademicoPorEstudiante($parametros);
			
			if(isset($estudianteWS->{'return'})){
				$estudiante = $estudianteWS->{'return'};
			}

			if(isset($historialAcademicoWS->{'return'})){
				$historialAcademicoList = $historialAcademicoWS->{'return'};
			}
			
			require_once('acciones/generarAnaliticoEstudiantePDF.php');
			
		}
		# OPERACION traerComisionesPorInscripcionEInstancia
		elseif($operacion == "traerComisionesPorInscripcionYCarrera"){
	
			$idInscripcion = $_GET["idInscripcion"];
			$idCarrera = $_GET["idCarrera"];

			$data = null;
			
			$parametros = array(
				'idInscripcion' => $idInscripcion,
				'idCarrera' => $idCarrera,
			);

			$materiaWS = $soapClient->traerComisionesPorInscripcionYCarrera($parametros);
			$cabeceraPlanillaMaterias = $soapClient->traerCabeceraPlanillaMaterias($parametros);
			
			if(isset($materiaWS->{'return'})){
				$materiasList = $materiaWS->{'return'};
			}

			if(isset($materiaWS->{'return'})){
				$cabecera = $cabeceraPlanillaMaterias->{'return'};
			}
			
			require_once('acciones/generarPlanillaMaterias.php');
			
		}
    }
    catch(Exception $ex){
        echo "Exception ocurred: " . $ex;
    }

?>
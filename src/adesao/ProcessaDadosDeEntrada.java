package adesao;

import java.util.Properties;

import gera.cpf.cnpj.GeradorCPFCNPJ;
import propertiesArquivo.ArquivoPropertie;

public class ProcessaDadosDeEntrada {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	static GeradorCPFCNPJ pegaCpfCnpj = new GeradorCPFCNPJ();
	static String cpf = pegaCpfCnpj.getCPF();
	static String cnpj = pegaCpfCnpj.getCNPJ();
	AdesaoVO adesao = new AdesaoVO();

	public void adesaoInclusaoSidecOP001PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String tipoConta = prop.getProperty(PropKeys.PROP_TIPO_CONTA);
			String operacao = prop.getProperty(PropKeys.PROP_OPERACAO);
			String agencia = prop.getProperty(PropKeys.PROP_AGENCIA);
			String conta = prop.getProperty(PropKeys.PROP_CONTA);
			String cpfCnpj = cpf;
			String horaInicio = prop.getProperty(PropKeys.PROP_HORARA_INICIO);
			String horaFinal = prop.getProperty(PropKeys.PROP_HORA_FINAL);
			String ddd = prop.getProperty(PropKeys.PROP_DDD);
			String telefone = prop.getProperty(PropKeys.PROP_TELEFONE);
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_VALOR_MINIMO_GPDEBITO);
			String valorMinimoCartaoDebito = prop.getProperty(PropKeys.PROP_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setTipoConta(tipoConta);
			AdesaoVO.setOperacao(operacao);
			AdesaoVO.setAgencia(agencia);
			AdesaoVO.setConta(conta);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setHoraInicio(horaInicio);
			AdesaoVO.setHoraFinal(horaFinal);
			AdesaoVO.setDdd(ddd);
			AdesaoVO.setTelefone(telefone);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoAlteracaoSidecOP001PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_INDICADOR_CPFCNPJ);
			String cpfCnpj = cpf;
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_ALTERACAO_VALOR_MINIMOGPDEBITO);
			String valorMinimoCartaoDebito = prop.getProperty(PropKeys.PROP_ALTERACAO_VALOR_MINIMOCARTAODEBITO);

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoConsultaSidecOP001PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_CONSULTA_INDICADORCPFCNPJ);
			String cpfCnpj = cpf;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoExclusaoSidecOP001PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_EXCLUSAO_INDICADORCPFCNPJ);
			String cpfCnpj = cpf;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoInclusaoSidecOP003PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String tipoConta = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_TIPOCONTA);
			String operacao = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_OPERACAO);
			String agencia = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_AGENCIA);
			String conta = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_CONTA);
			String cpfCnpj = cnpj;
			String horaInicio = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_HORAINICIO);
			String horaFinal = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_HORAFINAL);
			String ddd = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_DDD);
			String telefone = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_TELEFONE);
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_VALORMINIMOGPDEBITO);
			String valorMinimoCartaoDebito = prop.getProperty(PropKeys.PROP_INCLUSAO_PJ_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setTipoConta(tipoConta);
			AdesaoVO.setOperacao(operacao);
			AdesaoVO.setAgencia(agencia);
			AdesaoVO.setConta(conta);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setHoraInicio(horaInicio);
			AdesaoVO.setHoraFinal(horaFinal);
			AdesaoVO.setDdd(ddd);
			AdesaoVO.setTelefone(telefone);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoAlteracaoSidecOP003PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_ALTERACAO_PJ_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_ALTERACAO_PJ_VALOR_MINIMO_GP_DEBITO);
			String valorMinimoCartaoDebito = prop.getProperty(PropKeys.PROP_ALTERACAO_PJ_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoConsultaSidecOP003PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_CONSULTA_PJ_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void adesaoExclusaoSidecOP003PJComSucesso() {

		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_EXCLUSAO_PJ_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoInclusaoNsgdOP3701PFComSucesso() {

		try {
			Properties prop = propriedade.getPropAdesao();
			String tipoConta = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_TIPO_CONTA);
			String operacao = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_OPERACAO);
			String agencia = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_AGENCIA);
			String conta = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_CONTA);
			String cpfCnpj = cpf;
			String horaInicio = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_HORA_INICIO);
			String horaFinal = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_HORA_FINAL);
			String ddd = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_DDD);
			String telefone = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_TELEFONE);
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_VALOR_MINIMO_GP_DEBITO);
			String valorMinimoCartaoDebito = prop
					.getProperty(PropKeys.PROP_INCLUSAO_NSGD_PF_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setTipoConta(tipoConta);
			AdesaoVO.setOperacao(operacao);
			AdesaoVO.setAgencia(agencia);
			AdesaoVO.setConta(conta);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setHoraInicio(horaInicio);
			AdesaoVO.setHoraFinal(horaFinal);
			AdesaoVO.setDdd(ddd);
			AdesaoVO.setTelefone(telefone);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoAlteracaoNsgdOP3701PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PF_ALTERACAO_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cpf;
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_NSGD_PF_ALTERACAO_VALOR_MINIMO_GP_DEBITO);
			String valorMinimoCartaoDebito = prop
					.getProperty(PropKeys.PROP_NSGD_PF_ALTERACAO_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoConsultaNsgdOP3701PFComSucesso() {
		try {

			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PF_CONSULTA_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cpf;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoExclusaoNsgdOP3701PFComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PF_EXCLUSAO_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cpf;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoInclusaoNsgdOP3702PJComSucesso() {

		try {
			Properties prop = propriedade.getPropAdesao();
			String tipoConta = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_TIPO_CONTA);
			String operacao = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_OPERACAO);
			String agencia = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_AGENCIA);
			String conta = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_CONTA);
			String cpfCnpj = cnpj;
			String horaInicio = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_HORA_INICIO);
			String horaFinal = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_HORA_FINAL);
			String ddd = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_DDD);
			String telefone = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_TELEFONE);
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_VALOR_MINIMO_GP_DEBITO);
			String valorMinimoCartaoDebito = prop
					.getProperty(PropKeys.PROP_NSGD_PJ_INCLUSAO_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setTipoConta(tipoConta);
			AdesaoVO.setOperacao(operacao);
			AdesaoVO.setAgencia(agencia);
			AdesaoVO.setConta(conta);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setHoraInicio(horaInicio);
			AdesaoVO.setHoraFinal(horaFinal);
			AdesaoVO.setDdd(ddd);
			AdesaoVO.setTelefone(telefone);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoAlteracaoNsgdOP3702PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PJ_ALTERACAO_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;
			String valorMinimoGpDebito = prop.getProperty(PropKeys.PROP_NSGD_PJ_ALTERACAO_VALOR_MINIMO_GP_DEBITO);
			String valorMinimoCartaoDebito = prop
					.getProperty(PropKeys.PROP_NSGD_PJ_ALTERACAO_VALOR_MINIMO_CARTAO_DEBITO);

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);
			AdesaoVO.setValorMinimoGpDebito(valorMinimoGpDebito);
			AdesaoVO.setValorMinimoCartaoDebito(valorMinimoCartaoDebito);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoConsultaNsgdOP3702PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PJ_CONSULTA_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adesaoExclusaoNsgdOP3702PJComSucesso() {
		try {
			Properties prop = propriedade.getPropAdesao();
			String indicadorCpfCnpj = prop.getProperty(PropKeys.PROP_NSGD_PJ_EXCLUSAO_INDICADOR_CPF_CNPJ);
			String cpfCnpj = cnpj;

			AdesaoVO.setIndicadorCpfCnpj(indicadorCpfCnpj);
			AdesaoVO.setCpfCnpj(cpfCnpj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

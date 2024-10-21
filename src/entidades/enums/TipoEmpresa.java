package entidades.enums;

 

public enum TipoEmpresa {
    TECNOLOGIA("TECNOLOGIA"), 
    VAREJO("VAREJO"), 
    FINANCEIRA("FINANCEIRA"),
    ENSINO("ENSINO SUPERIOR");
	private String descricao;

	TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static TipoEmpresa getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (TipoEmpresa v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}


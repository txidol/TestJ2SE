package reflect.proxy.staticdemo;

public class ProxyObject implements ZhaoSheng{
	
	private ZhaoSheng trueObject;
	
	public ProxyObject(){
		System.out.println("���Ǵ�����");
		this.trueObject = new ObjectImpl();
	}

	@Override
	public void paoLu() {
		trueObject.paoLu();
	}
	
}

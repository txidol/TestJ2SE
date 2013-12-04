package reflect.proxy.staticdemo;

public class ProxyObject implements ZhaoSheng{
	
	private ZhaoSheng trueObject;
	
	public ProxyObject(){
		System.out.println("这是代理类");
		this.trueObject = new ObjectImpl();
	}

	@Override
	public void paoLu() {
		trueObject.paoLu();
	}
	
}

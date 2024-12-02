package io;

import java.io.IOException;

public class ConcreteCSVReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() throws IOException {
		return new ConcreteCSVReaderProduct();
	}

}

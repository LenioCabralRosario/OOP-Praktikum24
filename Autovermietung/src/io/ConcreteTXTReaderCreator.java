package io;

import java.io.IOException;

public class ConcreteTXTReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() throws IOException {
		return new ConcreteTXTReaderProduct();
	}

}

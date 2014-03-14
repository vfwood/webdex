package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Loader {
	public static void main(String[] args) throws Exception {
		// 0. Specify the analyzer for tokenizing text.
		// The same analyzer should be used for indexing and searching
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);

		// 1. create the index
		// Directory index = new RAMDirectory();
		Directory index = FSDirectory
				.open(new File("/Users/vfwood/pbs-search"));

		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
				analyzer);

		IndexWriter w = new IndexWriter(index, config);

		File inputDir = new File("/Users/vfwood/learn-play/pbs/data");
		File[] fileList = inputDir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		
		for (File inputFile : fileList) {
			InputFile ifile = new InputFile();
			ifile.filename = inputFile.getName();
			ifile.contents = read(inputFile);
			ifile.filesize = String.valueOf(ifile.contents.length());
			write(w, ifile);
		}
		w.close();
		System.out.println("Done.");
	}

	private static void write(IndexWriter w, InputFile ifile) throws Exception {
		Document doc = new Document();
		doc.add(new TextField("filename", ifile.filename, Field.Store.YES));
		doc.add(new TextField("contents", ifile.contents, Field.Store.YES));
		System.out.println("Writing contents as [" + ifile.contents.replace("\n", " ") + "]");
		doc.add(new TextField("added", new Date().toString(), Field.Store.YES));
		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("filesize", ifile.filesize, Field.Store.YES));
		w.addDocument(doc);
	}

	private static String read(File inputFile) throws Exception {
		System.out.println("Reading " + inputFile.getAbsolutePath());
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String full = "";
		String line = null;
		String sep = "";
		while ((line = bufferedReader.readLine()) != null) {
			full += (sep + line);
			sep = "\n";
		}
		bufferedReader.close();
		System.out.println("Done.");
		return full;
	}
}
package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Series {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String pathName = "G:\\TV Burning\\Game Of Thrones";
		String seriesName = "Game Of Thrones";
		String season = "06";
		String episodesNamePath = pathName + "\\sepisodes.txt";
		String resultNamePath = pathName + "\\result.txt";
		System.out.println(resultNamePath);
		
		File episodesFile = new File(episodesNamePath);
		File output = new File(resultNamePath);
		LineIterator episodesNameIter = FileUtils.lineIterator(episodesFile);
		int epiNum = 1;
		while (episodesNameIter.hasNext()) {
			String epiName = episodesNameIter.next().trim().replaceAll("\"", "");
			if(epiNum < 10) {
				Files.append(seriesName + " - S" + season + "E0" + epiNum + " - " + epiName + " 720p\n", output, Charsets.UTF_8);
			}
			else if (epiNum < 20){
				Files.append(seriesName + " - S" + season + "E" + epiNum + " - " + epiName + "720p\n", output, Charsets.UTF_8);
			}
			else {
				Files.append(seriesName + " - S" + season + "E" + epiNum + " - " + epiName + "\n", output, Charsets.UTF_8);
			}
			epiNum++;
		}
	}
	
}

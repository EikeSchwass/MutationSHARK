package de.ugoe.cs.smartshark.mutationSHARK;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.github.gumtreediff.client.Run;
import com.github.gumtreediff.gen.Generators;
import com.github.gumtreediff.io.TreeIoUtils;
import com.github.gumtreediff.tree.ITree;
import com.github.gumtreediff.tree.TreeContext;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
*
 */
public class MutationSHARK {
  public static int STORED_REFACTORINGS;

  public static void main(String[] args) {
    Run.initGenerators();
    try {
      TreeContext tree = Generators.getInstance().getTree("C:\\Users\\Eike\\OneDrive\\Documents\\Ausbildung\\Uni\\1919\\Masterarbeit\\Projekt\\mutationSHARK-master\\src\\main\\java\\de\\ugoe\\cs\\smartshark\\mutationSHARK\\MutationSHARK.java");
      ITree root = tree.getRoot();
      System.out.println(TreeIoUtils.toXml(tree).toString());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Parameter param = Parameter.getInstance();
    param.init(args);

    setLogLevel();
  }

  private static void setLogLevel() {
    Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    String level = Parameter.getInstance().getDebugLevel();

    switch (level) {
      case "INFO":
        root.setLevel(Level.INFO);
        break;
      case "DEBUG":
        root.setLevel(Level.DEBUG);
        break;
      case "WARNING":
        root.setLevel(Level.WARN);
        break;
      case "ERROR":
        root.setLevel(Level.ERROR);
        break;
      default:
        root.setLevel(Level.DEBUG);
        break;
    }
  }

}



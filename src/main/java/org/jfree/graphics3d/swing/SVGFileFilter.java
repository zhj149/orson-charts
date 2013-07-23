/**
 * (C)opyright 2013, by Object Refinery Limited
 */
package org.jfree.graphics3d.swing;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author dgilbert
 */
public class SVGFileFilter extends FileFilter {
  
  public SVGFileFilter() {
      
  }

    @Override
    public boolean accept(File f) {
      if (f.getName().endsWith(".svg")) {
        return true;
      }
      return false;
    }

    @Override
    public String getDescription() {
        return "Scalable Vector Graphics (SVG)";
    }
}
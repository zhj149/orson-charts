/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of this source file is prohibited.
 * 
 */

package com.orsoncharts.style;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import org.junit.Test;
import com.orsoncharts.StandardRectanglePainter;
import com.orsoncharts.TestUtils;

/**
 * Tests for the {@link StandardChartStyle} class.
 */
public class StandardChartStyleTest {
    
    @Test
    public void testCopyConstructor() {
        StandardChartStyle s1 = new StandardChartStyle();
        s1.setBackgroundPainter(new StandardRectanglePainter(Color.RED));
        s1.setTitleFont(new Font(Font.SERIF, Font.PLAIN, 2));
        s1.setTitlePaint(Color.CYAN);
        s1.setTitleBackgroundPaint(Color.YELLOW);
        s1.setSubtitleFont(new Font(Font.DIALOG, Font.PLAIN, 7));
        s1.setSubtitlePaint(Color.MAGENTA);
        s1.setSubtitleBackgroundPaint(Color.PINK);
        s1.setChartBoxColor(Color.GREEN);
        s1.setXAxisGridlinesVisible(!s1.getXAxisGridlinesVisible());
        s1.setYAxisGridlinesVisible(!s1.getYAxisGridlinesVisible());
        s1.setZAxisGridlinesVisible(!s1.getZAxisGridlinesVisible());
        s1.setGridlineColor(Color.BLUE);
        s1.setGridlineStroke(new BasicStroke(2.0f));
        s1.setSectionLabelFont(new Font(Font.MONOSPACED, Font.PLAIN, 8));
        s1.setSectionLabelColor(Color.WHITE);
        s1.setStandardColors(new Color[] {Color.BLACK, Color.WHITE});
        s1.setAxisLabelFont(new Font(Font.SERIF, Font.PLAIN, 17));
        s1.setAxisLabelColor(Color.DARK_GRAY);
        s1.setAxisTickLabelFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
        s1.setAxisTickLabelColor(Color.ORANGE);
        s1.setLegendHeaderFont(new Font(Font.MONOSPACED, Font.BOLD, 9));
        s1.setLegendHeaderColor(Color.CYAN);
        s1.setLegendHeaderBackgroundColor(Color.RED);
        s1.setLegendItemShape(new Rectangle(1, 2, 3, 4));
        s1.setLegendItemFont(new Font(Font.SERIF, Font.BOLD, 21));
        s1.setLegendItemColor(Color.GREEN);
        s1.setLegendItemBackgroundColor(Color.LIGHT_GRAY);
        s1.setLegendFooterFont(new Font(Font.MONOSPACED, Font.ITALIC, 5));
        s1.setLegendFooterColor(Color.BLUE);
        s1.setLegendFooterBackgroundColor(Color.BLACK);
        
        StandardChartStyle s2 = new StandardChartStyle(s1);
        assertEquals(new StandardRectanglePainter(Color.RED), 
                s2.getBackgroundPainter());
        assertEquals(new Font(Font.SERIF, Font.PLAIN, 2), s2.getTitleFont());
        assertEquals(Color.CYAN, s2.getTitlePaint());
        assertEquals(Color.YELLOW, s2.getTitleBackgroundPaint());
        assertEquals(new Font(Font.DIALOG, Font.PLAIN, 7), 
                s2.getSubtitleFont());
        assertEquals(Color.MAGENTA, s2.getSubtitlePaint());
        assertEquals(Color.PINK, s2.getSubtitleBackgroundPaint());
        assertEquals(Color.GREEN, s2.getChartBoxColor());
        assertEquals(s1.getXAxisGridlinesVisible(), 
                s2.getXAxisGridlinesVisible());
        assertEquals(s1.getYAxisGridlinesVisible(), 
                s2.getYAxisGridlinesVisible());
        assertEquals(s1.getZAxisGridlinesVisible(), 
                s2.getZAxisGridlinesVisible());
        assertEquals(Color.BLUE, s2.getGridlineColor());
        assertEquals(new BasicStroke(2.0f), s2.getGridlineStroke());
        assertEquals(new Font(Font.MONOSPACED, Font.PLAIN, 8), 
                s2.getSectionLabelFont());
        assertEquals(Color.WHITE, s2.getSectionLabelColor());
        assertArrayEquals(new Color[] {Color.BLACK, Color.WHITE}, 
                s2.getStandardColors());
        assertEquals(new Font(Font.SERIF, Font.PLAIN, 17), 
                s2.getAxisLabelFont());
        assertEquals(Color.DARK_GRAY, s2.getAxisLabelColor());
        assertEquals(new Font(Font.SANS_SERIF, Font.PLAIN, 11), 
                s2.getAxisTickLabelFont());
        assertEquals(Color.ORANGE, s2.getAxisTickLabelColor());
        assertEquals(new Font(Font.MONOSPACED, Font.BOLD, 9), 
                s2.getLegendHeaderFont());
        assertEquals(Color.CYAN, s2.getLegendHeaderColor());
        assertEquals(Color.RED, s2.getLegendHeaderBackgroundColor());
        assertEquals(new Rectangle(1, 2, 3, 4), s2.getLegendItemShape());
        assertEquals(new Font(Font.SERIF, Font.BOLD, 21), 
                s2.getLegendItemFont());
        assertEquals(Color.GREEN, s2.getLegendItemColor());
        assertEquals(Color.LIGHT_GRAY, s2.getLegendItemBackgroundColor());
        assertEquals(new Font(Font.MONOSPACED, Font.ITALIC, 5), 
                s2.getLegendFooterFont());
        assertEquals(Color.BLUE, s2.getLegendFooterColor());
        assertEquals(Color.BLACK, s2.getLegendFooterBackgroundColor());
    } 
    
    @Test
    public void testEquals() {
        StandardChartStyle s1 = new StandardChartStyle();
        StandardChartStyle s2 = new StandardChartStyle();
        assertTrue(s1.equals(s2));
        assertFalse(s1.equals(null));
        
        // backgroundPainter
        s1.setBackgroundPainter(new StandardRectanglePainter(Color.RED));
        assertFalse(s1.equals(s2));        
        s2.setBackgroundPainter(new StandardRectanglePainter(Color.RED));
        assertTrue(s1.equals(s2));
        
        // titleFont
        s1.setTitleFont(new Font("Dialog", Font.PLAIN, 23));
        assertFalse(s1.equals(s2));        
        s2.setTitleFont(new Font("Dialog", Font.PLAIN, 23));
        assertTrue(s1.equals(s2));
        
        // titlePaint
        s1.setTitlePaint(Color.GREEN);
        assertFalse(s1.equals(s2));        
        s2.setTitlePaint(Color.GREEN);
        assertTrue(s1.equals(s2));
        
        // titleBackgroundPaint
        s1.setTitleBackgroundPaint(Color.RED);
        assertFalse(s1.equals(s2));        
        s2.setTitleBackgroundPaint(Color.RED);
        assertTrue(s1.equals(s2));
        
        // subtitleFont
        s1.setSubtitleFont(new Font("Dialog", Font.PLAIN, 27));
        assertFalse(s1.equals(s2));        
        s2.setSubtitleFont(new Font("Dialog", Font.PLAIN, 27));
        assertTrue(s1.equals(s2));
        
        // subtitleForegroundPaint
        s1.setSubtitlePaint(Color.CYAN);
        assertFalse(s1.equals(s2));        
        s2.setSubtitlePaint(Color.CYAN);
        assertTrue(s1.equals(s2));
        
        // subtitleBackgroundPaint
        s1.setSubtitleBackgroundPaint(Color.YELLOW);
        assertFalse(s1.equals(s2));        
        s2.setSubtitleBackgroundPaint(Color.YELLOW);
        assertTrue(s1.equals(s2));
        
        // chartBoxColor
        s1.setChartBoxColor(Color.DARK_GRAY);
        assertFalse(s1.equals(s2));        
        s2.setChartBoxColor(Color.DARK_GRAY);
        assertTrue(s1.equals(s2));

        // xAxisGridlinesVisible;
        s1.setXAxisGridlinesVisible(!s1.getXAxisGridlinesVisible());
        assertFalse(s1.equals(s2));        
        s2.setXAxisGridlinesVisible(!s2.getXAxisGridlinesVisible());
        assertTrue(s1.equals(s2));
        
        // yAxisGridlinesVisible;
        s1.setYAxisGridlinesVisible(!s1.getYAxisGridlinesVisible());
        assertFalse(s1.equals(s2));        
        s2.setYAxisGridlinesVisible(!s2.getYAxisGridlinesVisible());
        assertTrue(s1.equals(s2));
    
        // zAxisGridlinesVisible;
        s1.setZAxisGridlinesVisible(!s1.getZAxisGridlinesVisible());
        assertFalse(s1.equals(s2));        
        s2.setZAxisGridlinesVisible(!s2.getZAxisGridlinesVisible());
        assertTrue(s1.equals(s2));
    
        // gridlineColor;
        s1.setGridlineColor(Color.MAGENTA);
        assertFalse(s1.equals(s2));        
        s2.setGridlineColor(Color.MAGENTA);
        assertTrue(s1.equals(s2));
        
        // gridlineStroke;
        s1.setGridlineStroke(new BasicStroke(5f));
        assertFalse(s1.equals(s2));        
        s2.setGridlineStroke(new BasicStroke(5f));
        assertTrue(s1.equals(s2));
        
        // sectionLabelFont;
        s1.setSectionLabelFont(new Font("Dialog", Font.ITALIC, 7));
        assertFalse(s1.equals(s2));        
        s2.setSectionLabelFont(new Font("Dialog", Font.ITALIC, 7));
        assertTrue(s1.equals(s2));
        
        // sectionLabelColor;
        s1.setSectionLabelColor(Color.DARK_GRAY);
        assertFalse(s1.equals(s2));        
        s2.setSectionLabelColor(Color.DARK_GRAY);
        assertTrue(s1.equals(s2));

        // standardColors;
        s1.setStandardColors(Color.RED, Color.GREEN, Color.BLUE);
        assertFalse(s1.equals(s2));        
        s2.setStandardColors(Color.RED, Color.GREEN, Color.BLUE);
        assertTrue(s1.equals(s2));
        
        // axisLabelFont;
        s1.setAxisLabelFont(new Font("Dialog", Font.PLAIN, 18));
        assertFalse(s1.equals(s2));        
        s2.setAxisLabelFont(new Font("Dialog", Font.PLAIN, 18));
        assertTrue(s1.equals(s2));
        
        // axisLabelColor;
        s1.setAxisLabelColor(Color.WHITE);
        assertFalse(s1.equals(s2));        
        s2.setAxisLabelColor(Color.WHITE);
        assertTrue(s1.equals(s2));
        
        // axisTickLabelFont;
        s1.setAxisTickLabelFont(new Font("Dialog", Font.BOLD, 2));
        assertFalse(s1.equals(s2));        
        s2.setAxisTickLabelFont(new Font("Dialog", Font.BOLD, 2));
        assertTrue(s1.equals(s2));
        
        // axisTickLabelColor;
        s1.setAxisTickLabelColor(Color.GRAY);
        assertFalse(s1.equals(s2));        
        s2.setAxisTickLabelColor(Color.GRAY);
        assertTrue(s1.equals(s2));
        
        // legendHeaderFont;
        s1.setLegendHeaderFont(new Font("Dialog", Font.BOLD, 99));
        assertFalse(s1.equals(s2));        
        s2.setLegendHeaderFont(new Font("Dialog", Font.BOLD, 99));
        assertTrue(s1.equals(s2));
        
        // legendItemFont;
        s1.setLegendItemFont(new Font("Dialog", Font.BOLD, 99));
        assertFalse(s1.equals(s2));        
        s2.setLegendItemFont(new Font("Dialog", Font.BOLD, 99));
        assertTrue(s1.equals(s2));
    
        // legendFooterFont;
        s1.setLegendFooterFont(new Font("Dialog", Font.BOLD, 99));
        assertFalse(s1.equals(s2));        
        s2.setLegendFooterFont(new Font("Dialog", Font.BOLD, 99));
        assertTrue(s1.equals(s2));
    }
    
    @Test
    public void testSerialization() {
        StandardChartStyle s1 = new StandardChartStyle();
        StandardChartStyle s2 = (StandardChartStyle) TestUtils.serialized(s1);
        assertTrue(s1.equals(s2));
    }

}

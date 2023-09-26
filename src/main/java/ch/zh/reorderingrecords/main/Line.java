package ch.zh.reorderingrecords.main;

public record Line(String identifier,String line) implements Comparable<Line>
    {
    
    public int compareTo(Line record)
        {
        return identifier.compareTo(record.identifier);
        }
    
    }

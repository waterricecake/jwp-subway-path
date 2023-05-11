package subway.dto;

import subway.domain.LineInfo;

public class LineResponse {
    private Long id;
    private String name;
    private String color;

    public LineResponse(LineInfo lineInfo) {
        this(lineInfo.getId(), lineInfo.getName(), lineInfo.getColor());
    }

    public LineResponse(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public static LineResponse of(LineInfo line) {
        return new LineResponse(line.getId(), line.getName(), line.getColor());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

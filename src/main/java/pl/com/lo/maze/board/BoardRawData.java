package pl.com.lo.maze.board;

import java.util.stream.Stream;

public class BoardRawData {

    private Integer width;
    private Integer height;
    private Stream<Long> data;

    public BoardRawData(Integer width, Integer height, Stream<Long> data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Stream<Long> getData() {
        return data;
    }

}

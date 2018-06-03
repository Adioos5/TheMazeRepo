package pl.com.lo.maze.board.reader;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.com.lo.maze.board.Board;
import pl.com.lo.maze.board.BoardRawData;
import pl.com.lo.maze.common.ResourceHelper;
import pl.com.lo.maze.common.TextFileReader;
import pl.com.lo.maze.configuration.Configuration;
import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.tile.Tile;
import pl.com.lo.maze.tile.builder.TileBuilder;
import pl.com.lo.maze.tile.builder.TileBuilderFactory;

public class TextBoardReader implements BoardReader {

    private TileBuilderFactory tileBuilderFactory;

    public TextBoardReader(Map<Graphics, BufferedImage> graphics) {
        tileBuilderFactory = new TileBuilderFactory(graphics);
    }

    @Override
    public Board createBoard(BoardRawData boardRawData) {
        List<Tile> tiles = boardRawData.getData()
            .map(this::longToChar)
            .map(this::charToTile)
            .collect(Collectors.toList());

        return new Board(
            boardRawData.getWidth(),
            boardRawData.getHeight(),
            tiles);
    }

    @Override
    public BoardRawData readBoardRawData(String filePath) {
        Optional<Path> optionalFilePath = ResourceHelper.getFilePath(Configuration.MAP_BASE_DIR + filePath);
        List<String> rowsStringified = TextFileReader.readAsListOfStrings(optionalFilePath);

        int width = Optional.ofNullable(rowsStringified)
            .map(list -> list.get(0))
            .map(String::length)
            .orElse(0);

        int height = Optional.ofNullable(rowsStringified)
            .map(List::size)
            .orElse(0);

        Stream<Long> data = rowsStringified.stream()
            .collect(Collectors.joining(""))
            .chars()
            .mapToObj(Long::valueOf);

        return new BoardRawData(width, height, data);
    }

    private Character longToChar(Long l) {
        return Optional.ofNullable(l)
            .map(val -> (char) val.longValue())
            .filter(Character::isDefined)
            .map(Character::valueOf)
            .orElse(' ');
    }

    private Tile charToTile(Character ch) {
        TileBuilder builder = tileBuilderFactory.getBuilder(ch);
        return builder.build();
    }
}

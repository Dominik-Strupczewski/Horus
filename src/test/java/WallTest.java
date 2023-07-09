import org.example.Block;
import org.example.BlockImp;
import org.example.CompositeBlockImp;
import org.example.Wall;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

public class WallTest {
    Wall wall ;
    @Before
            public void setUp() {
        Block blok1 = new BlockImp("Red", "Wood");
        Block blok2 = new BlockImp("Black", "coal");
        Block blok3 = new BlockImp("White", "Glass");
        Block blok4 = new CompositeBlockImp(List.of(new BlockImp("Green", "Grass") , new BlockImp("Yellow", "Sand")));
        Block blok5 = new BlockImp("Purple", "Grass") ;
        List<Block> bLocks = List.of(blok1, blok2, blok3, blok4, blok5);
        wall = new Wall(bLocks);
    }

    @Test
    public void givenValidMaterialThenReturnBLockThisMaterial() {

        List<Block> result = wall.findBlocksByMaterial("Grass");

        Assert.assertThat(result.get(0).getMaterial(), is("Grass"));
        Assert.assertFalse(result.isEmpty());

    }

    @Test
    public void givenInvalidMaterialThenReturnEmptyList() {

        List<Block> result = wall.findBlocksByMaterial("Paper");
        Assert.assertTrue(result.isEmpty());

    }

    @Test
    public void givenStructureThenReturnNumberOfElements() {

        int result = wall.count();
        Assert.assertEquals(7,result);


    }

    @Test
    public void givenValidColorThenReturnBlockWithGivenColor()
    {

        Assert.assertEquals("Red",wall.findBlockByColor("Red").get().getColor());

    }



}
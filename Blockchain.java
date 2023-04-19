import java.util.ArrayList;
import java.util.List;

public class Blockchain{

    public List<Block> chain = new ArrayList<Block>();
    public int prefix;
    public String prefixString;
    public Blockchain(int prefix) {
        this.prefix = prefix;
        this.prefixString = new String(new char[prefix]).replace('\0', '0');
    }

    public boolean isBlockchainValid() {
        boolean flag = true;
        for (int i = 0; i < chain.size(); i++) {
            String previousHash = i == 0 ? "0"
                    : chain.get(i - 1)
                    .getHash();
            flag = chain.get(i).getHash().equals(chain.get(i).calculateBlockHash())
                    && previousHash.equals(chain.get(i).getPreviousHash())
                    && chain.get(i).getHash().substring(0, prefix).equals(prefixString);
            if (!flag)
                break;
        }
        return flag;
    }

    public void addblock(Block block){
        chain.add(block);
    }

    public void showchain() {
        for (Block b : this.chain) {
            System.out.println(b);
            System.out.println("\n");
        }
    }

    public int getsize() {
        return chain.size();
    }

    public int getprefix() {
        return prefix;
    }

    public String getprefixstring() {
        return prefixString;
    }
}
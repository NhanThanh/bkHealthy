package com.ttcnpm.bk_healthy.model;

import com.ttcnpm.bk_healthy.R;

/**
 * Created by Huynh Hong Hien on 4/25/2017.
 */

public class thantren {
    private String name;
    private String description;
    private int imageResourceId;

    public static final thantren[] thantrens = {
            new thantren("Đo sàn mở rộng", "Bước 1: Bắt đầu với tư thế chống đẩy, nhưng gập cánh tay, tỳ khuỷu tay xuống đất và dồn trọng lượng lên cánh tay và ngón chân đặt trên sàn.\nBước 2: Giữ vững vị trí này với lưng thẳng và cố gắng thở bình thường trong vòng 30 giây.",
                    R.drawable.do_san),
            new thantren("Gập bụng chử V", "Bước 1: Nằm ngửa, đầu gối cong và đặt tay ra phía sau đầu và khóa lại bằng cách đan ngón tay vào nhau.\nBước 2: Giữ chặt gót chân dưới sàn nhà trong khi nhấc thân trên lên tao thành chữ V với đùi. Dừng lại 1-2 giây sau đó từ từ hạ thân trên xuống vị trí bắt đầu. Thực hiện động tác này 12 lần.",
                    R.drawable.gap_bung),
            new thantren("Gập bụng nâng cao", "Bước 1: Nằm thẳng, duỗi cánh tay lên phía trên đỉnh đầu. Đồng thời dùng cơ chính giữa bụng nâng thân trên và người dậy, hai tay đưa về phía trước chạm mũi chân.\nBước 2: Sau khi lưng, bụng và đùi kết hợp tạo thành hình chữ V, bạn quay trở lại vị trí ban đầu. Thực hiện động tác này 12 lần.",
                    R.drawable.gap_bung_nang_cao),
            new thantren("Gập bụng ngược", "Bước 1: Nằm ngửa trên mặt đất, chân duỗi thẳng, để hai tay song song với cơ thể, lòng bàn tay đặt cố định trên mặt đất.\nBước 2: Nâng chân lên cho tới khi đùi vuông góc với mặt đất và hai bàn chân sát vào nhau để song song với mặt đất.\nBước 3: Trở lại vị trí ban đầu, nhưng không để chân chạm xuống đất. Điều này giúp duy trì sự căng cơ bụng trong suốt quá trình tập luyện. Lặp lại động tác này 12 lần.",
                    R.drawable.gap_bung_nguoc),
            new thantren("Nâng tay dài", "Bước 1: Nằm ngửa, đầu gối cong, duỗi cánh tay của bạn thẳng ra phía sau. \nBước 2: Di chuyển cánh tay thẳng lên trên đầu, từ từ nâng cả đầu và cánh tay gập người lên nhưng không quá cao, rồi hạ người về vị trí cũ. Lặp lại động tác này 12 lần.",
                    R.drawable.nang_tay_dai)
    };

    private thantren(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}

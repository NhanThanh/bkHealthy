package com.ttcnpm.bk_healthy.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ttcnpm.bk_healthy.R;
import com.ttcnpm.bk_healthy.helper.CircularImageView;
import com.ttcnpm.bk_healthy.views.CheDoAnActivity;
import com.ttcnpm.bk_healthy.views.FoodActivity;
import com.ttcnpm.bk_healthy.views.WelcomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CheDoAnAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<String> data;
    private static LayoutInflater inflater = null;

    public CheDoAnAdapter(Context context, ArrayList<String> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.row_che_do_an, null);
        }
        try {
            JSONObject json_data = new JSONObject(data.get(position));
            if(json_data.getString("menu_image").equals("1")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.nguoi_gia);
            }else if(json_data.getString("menu_image").equals("2")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.tre_em);
            }else if(json_data.getString("menu_image").equals("3")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.nguoi_benh);
            }else if(json_data.getString("menu_image").equals("4")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.nguoi_tap_gym);
            }else if(json_data.getString("menu_image").equals("5")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.an_kieng);
            }else if(json_data.getString("menu_image").equals("6")){
                ((CircularImageView) vi.findViewById(R.id.menu_image)).setImageResource(R.drawable.tang_can);
            }
            ((TextView)vi.findViewById(R.id.menu_name)).setText(json_data.getString("menu_name"));
            vi.setOnClickListener(clickMenu(json_data.getString("menu_image")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vi;
    }


    public View.OnClickListener clickMenu(final String menu_id){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (menu_id) {
                    case "1":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("     ★ Người Già ★")
                                .setMessage(
                                        "✪ Chế độ ăn hợp lý cho người cao tuổi :\n\n" +
                                                "+ Hạn chế thực phẩm nhiều đường ngọt, kể cả mật ong. Chế độ ăn hàng ngày nên giảm cơm và dùng thêm các loại ngô, khoai. Mỗi tuần nên ăn ít nhất 3 lần cá và không ăn quá 3 quả trứng.\n" +
                                                "+ Theo khuyến nghị của Viện Dinh dưỡng quốc gia, nhu cầu năng lượng ở người trên 60 tuổi là 1.900 kcal với nam và 1.800 kcal với nữ.\n" +
                                                "+ Mỗi tuần nên ăn ít nhất 3 lần cá và không ăn quá 3 quả trứng.\n\n" +
                                                "– Một số lời khuyên dinh dưỡng dành cho người lớn tuổi:\n" +
                                                "\n" +
                                                "• Cần ăn đa dạng thực phẩm để nhận được nhiều loại dưỡng chất cần thiết cho cơ thể, đảm bảo đủ năng lượng, cân đối đầy đủ các chất, phân bố bữa ăn hợp lý.\n" +
                                                "\n" +
                                                "• Hạn chế mỡ động vật, nên ăn nhiều cá, các loại đậu, ngũ cốc nguyên hạt. \n" +
                                                "\n" +
                                                "• Chọn gạo mềm, dẻo, không xát quá trắng. Trong chế độ ăn hàng ngày nên giảm cơm và dùng thêm các loại ngô, khoai.\n" +
                                                "\n" +
                                                "• Bảo đảm đủ chất đạm. Nên ăn cá nhiều hơn thịt, mỗi tuần nên ăn ít nhất 3 lần cá và không ăn quá 3 quả trứng. Nên tăng sử dụng đạm thực vật như đậu hũ, tàu hũ ky, sữa đậu nành, các loại đậu đỗ...\n" +
                                                "\n" +
                                                "• Thường xuyên uống sữa, chọn loại giảm béo, ít đường để bổ sung canxi đề phòng loãng xương, có thể chọn sữa chua sẽ dễ tiêu hóa hơn. Ngoài ra, để chú trọng phòng ngừa loãng xương cần tăng cường thực phẩm giàu canxi như cá nhỏ ăn luôn xương, tép ăn nguyên cả vỏ, rau xanh, sữa đậu nành...\n" +
                                                "\n" +
                                                "• Tăng cường sử dụng thực phẩm giàu chất chống oxy hóa (vitamin C, vitamin E, beta-caroten) có trong rau quả tươi, nhiều màu sắc, đặc biệt là rau xanh lá như rau ngót, rau đay, mồng tơi..., dầu thực vật, các loại gia vị như hành, hẹ, gừng, nghệ...\n" +
                                                "\n" +
                                                "• Uống đủ nước, khoảng 6-8 ly mỗi ngày. Chú ý uống nước thường xuyên dù không khát, nhất là vào mùa hè.\n" +
                                                "\n" +
                                                "• Hạn chế thực phẩm nhiều đường ngọt, kể cả mật ong.\n" +
                                                "\n" +
                                                "• Ăn muối vừa phải, giảm gia vị mặn (muối, nước tương, nước mắm), hạn chế thực phẩm mặn như khô, mắm, thức ăn kho mặn...\n" +
                                                "\n" +
                                                "• Hạn chế thức uống có cồn.\n" +
                                                "\n" +
                                                "• Ăn đa dạng nhiều loại trái cây nhiều màu sắc. Riêng với trái cây ngọt chỉ nên ăn vừa phải. Nên ăn cả trái sẽ giúp nhận được nhiều chất xơ hơn là chỉ ép lấy nước. \n\n" +
                                                "– Đặc biệt lưu ý hạn chế tác nhân gây ung thư:\n" +
                                                "\n" +
                                                "• Tránh thức ăn bị mốc vì có thể chứa aflatoxin gây ung thư gan.\n" +
                                                "\n" +
                                                "• Không đun chất béo ở nhiệt độ cao để phòng ngừa chất béo dạng trans gây nguy hiểm.\n" +
                                                "\n" +
                                                "• Thay cách chế biến chiên, xào bằng luộc, hấp.\n" +
                                                "\n" +
                                                "• Hạn chế thịt muối xông khói, phơi khô...\n" +
                                                "\n" +
                                                "• Hạn chế các chất gây ô nhiễm, rửa sạch rau quả nhiều lần, gọt vỏ khi ăn.\n" +
                                                "\n" +
                                                "• Ngoài chế độ dinh dưỡng hợp lý, người cao tuổi cần vận động vừa sức, thường xuyên để giúp tăng tuần hoàn máu, ăn ngon miệng, chắc xương, hạn chế mất khối cơ, giảm táo bón, rèn luyện trí não.")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();
                        break;
                    case "2":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("          ★ Trẻ Em ★")
                                .setMessage("✪ Giai đoạn từ sơ sinh đến 4 tháng :\n" +
                                        "– Hành vi ăn :\n" +
                                        "• Bản năng sẽ khiến bé quay về phía núm vú của mẹ để tìm nguồn dinh dưỡng.\n" +
                                        "– Thức ăn cho bé :\n" +
                                        "• Chỉ nuôi con bằng sữa mẹ hoặc sữa công thức.\n" +
                                        "– Lời khuyên :\n" +
                                        "• Đường tiêu hóa của bé vẫn đang phát triển nên giai đoạn này bạn chưa nên cho bé ăn thức ăn đặc.\n\n" +
                                        "✪ Giai đoạn từ 4-6 tháng tuổi :\n" +
                                        "– Bạn có thể cho bé thử nghiệm thức ăn dặm nếu bé :\n" +
                                        "• Có thể kiểm soát các cử động của đầu và cổ.\n" +
                                        "• Có thể ngồi lên với sự giúp đỡ của người thân.\n" +
                                        "• Có thể giả vờ nhai.\n" +
                                        "• Tăng cân lên gấp 2 lần so với lúc mới sinh.\n" +
                                        "• Thể hiện sự thích thú với thức ăn.\n" +
                                        "• Có thể ngậm một cái muỗng.\n" +
                                        "• Có thể dùng lưỡi để di chuyển thức ăn từ trước ra sau miệng.\n" +
                                        "• Có thể đẩy lưỡi qua lại.\n" +
                                        "• Có vẻ đói sau khi đã bú mẹ 8-10 lần hoặc sau khi đã uống khoảng 1 lít sữa công thức trong một ngày.\n" +
                                        "• Mọc răng.\n" +
                                        "– Thức ăn cho bé :\n" +
                                        "• Sữa mẹ hoặc sữa bột.\n" +
                                        "• Thức ăn xay nhuyễn như khoai lang, bí, táo, chuối, đào hoặc lê và ngũ cốc hơi sệt.\n" +
                                        "– Liều lượng mỗi ngày :\n" +
                                        "• Bắt đầu với khoảng 1 muỗng cà phê thức ăn hoặc ngũ cốc xay nhuyễn, trộn ngũ cốc với 4-5 muỗng cà phê sữa mẹ hoặc sữa công thức.\n" +
                                        "• Tăng thêm khẩu phần với 1 thìa thức ăn xay nhuyễn hoặc 1 muỗng canh bột ngũ cốc trộn với sữa mẹ hoặc sữa công thức, hai lần/ngày. Nếu cho bé ăn ngũ cốc, từ từ cho ít sữa lại để tăng độ đặc.\n" +
                                        "– Lời khuyên :\n" +
                                        "• Nếu lúc đầu bé không chịu ăn ngũ cốc, nên để một vài ngày rồi thử lại.\n\n" +
                                        "✪ Giai đoạn 6-8 tháng tuổi :\n" +
                                        "– Thức ăn cho bé :\n" +
                                        "• Sữa mẹ hoặc sữa công thức.\n" +
                                        "• Các loại ngũ cốc giàu chất sắt (gạo, lúa mạch, yến mạch).\n" +
                                        "• Trái cây xay nhuyễn hoặc nấu nhừ (chuối, lê, táo, đào).\n" +
                                        "• Rau xay nhuyễn hoặc nấu nhừ (bơ, cà rốt nấu chín, bí, khoai lang).\n" +
                                        "• Thịt xay nhuyễn (thịt gà, thịt heo, thịt bò).\n" +
                                        "• Đậu phụ xay nhuyễn.\n" +
                                        "• Các loại đậu xay nhuyễn (đậu đen, đậu xanh, đậu tằm, đậu đen, đậu lăng..).\n" +
                                        "– Liều lượng mỗi ngày :\n" +
                                        "• 3-9 muỗng canh ngũ cốc, cho bé ăn từ 2-3 lần.\n" +
                                        "• 1 muỗng cà phê trái cây, tăng dần đến 1/4 đến 1/2 chén trong 2-3 lần.\n" +
                                        "• 1 muỗng cà phê rau, dần dần tăng lên 1/4 đến 1/2 chén trong 2-3 lần.\n" +
                                        "– Lời khuyên :\n" +
                                        "• Sau khi cho bé thử một món mới, nên ngưng và đợi một vài ngày để biết được bé có hợp hay bị dị ứng với món đó không\n\n" +
                                        "✪ Giai đoạn 8-10 tháng tuổi :\n" +
                                        "– Dấu hiệu sẵn sàng để ăn thức ăn dặm và ăn bốc :\n" +
                                        "• Bé thích dùng tay bốc thức ăn.\n" +
                                        "• Bé có thể chuyển các đồ vật từ tay này sang tay khác.\n" +
                                        "• Bé muốn bỏ mọi thứ vào miệng.\n" +
                                        "• Chuyển động hàm khi nhai.\n" +
                                        "– Thức ăn cho bé :\n" +
                                        "• Sữa mẹ hoặc sữa bột.\n" +
                                        "• Một lượng nhỏ phô mai mềm tiệt trùng, sữa chua, phô mai (tuy nhiên, không nên dùng sữa bò cho đến khi bé được 1 tuổi).\n" +
                                        "• Các loại ngũ cốc giàu chất sắt (gạo, lúa mạch, lúa mì, yến mạch, ngũ cốc hỗn hợp).\n" +
                                        "• Trái cây và rau quả (chuối, đào, lê, bơ, cà rốt nấu chín, bí, khoai tây, khoai lang).\n" +
                                        "• Các loại thực phẩm bé có thể cầm tay và ăn (bánh mì nướng cắt nhỏ, chuối chín cắt lát, nui nấu chín, bánh quy giòn, bánh ngũ cốc ít đường hình chữ O).\n" +
                                        "• Một lượng nhỏ thực phẩm giàu đạm (trứng, thịt xay nhuyễn, thịt gia cầm, cá không xương, đậu phụ, đậu Hà Lan, đậu đen).\n" +
                                        "– Liều lượng mỗi ngày :\n" +
                                        "• 1/4 đến 1/3 chén bơ sữa .\n" +
                                        "• 1/4 đến 1/2 chén ngũ cốc bổ sung chất sắt.\n" +
                                        "• 1/4 đến 1/2 chén trái cây.\n" +
                                        "• 1/4 đến 1/2 chén rau.\n" +
                                        "• 1/8 đến 1/4 chén thức ăn giàu đạm.\n" +
                                        "– Lời khuyên :\n" +
                                        "• Sau khi cho bé thử một món mới, nên ngưng và đợi một vài ngày để biết được bé có hợp hay bị dị ứng với món đó không.\n\n" +
                                        "✪ Giai đoạn 10 đến 12 tháng tuổi :\n" +
                                        "– Dấu hiệu sẵn sàng để ăn thức ăn dặm :\n" +
                                        "• Bé nuốt thức ăn dễ dàng hơn.\n" +
                                        "• Bé mọc răng.\n" +
                                        "• Bé không còn đẩy thức ăn ra khỏi lưỡi.\n" +
                                        "– Thức ăn cho bé :\n" +
                                        "• Sữa mẹ hoặc sữa bột.\n" +
                                        "• Phô mai mềm tiệt trùng, sữa chua, phô mai (không nên dùng sữa bò cho đến khi 1 tuổi).\n" +
                                        "• Các loại ngũ cốc giàu sắt.\n" +
                                        "• Trái cây nghiền hoặc bóc vỏ và cắt thành từng miếng vuông.\n" +
                                        "• Rau hấp cho chín mềm, cắt thành miếng nhỏ.\n" +
                                        "• Các món ăn kết hợp (mì ống và phô mai, thịt hầm).\n" +
                                        "• Thực phẩm giàu chất đạm.\n" +
                                        "• Thực phẩm cho bé ăn bốc.\n" +
                                        "– Liều lượng mỗi ngày :\n" +
                                        "• 1/3 chén bơ sữa.\n" +
                                        "• 1/4 đến 1/2 chén ngũ cốc giàu sắt.\n" +
                                        "• 1/4 đến 1/2 chén trái cây.\n" +
                                        "• 1/4 đến 1/2 chén rau.\n" +
                                        "• 1/8 đến 1/4 chén thức ăn kết hợp.\n" +
                                        "• 1/8 đến 1/4 chén thức ăn giàu đạm.\n" +
                                        "– Lời khuyên :\n" +
                                        "• Sau khi cho bé thử một món mới, nên ngưng và đợi một vài ngày để biết được bé có hợp hay bị dị ứng với món đó không.")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }

                                }).show();
                        break;
                    case "3":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("     ★ Người Bệnh ★")
                                .setMessage(
                                        "– Một số thức ăn dành cho người lớn tuổi:\n" +
                                                "• Cháo hành nóng, tía tô là món ăn dễ tiêu hóa, giải cảm tốt – món ăn đặc biệt tốt cho người bị cảm cúm.\n" +
                                                "\n" +
                                                "• Cháo gà nóng, soup gà: Các nhà khoa học cho biết nước súp gà có thành phần của cysteine, một amino acid có thể phối hợp với những sinh tố C, E và chất selenium trong tác dụng chống oxy hoá.\n" +
                                                "\n" +
                                                "• Tỏi: Các nghiên cứu đã chỉ ra rằng trong tỏi có hàm lượng chất chống oxy hóa cao nhất trong các loại gia vị. Theo Đông y tỏi vị cay, tính ấm, có thể tăng cường sự lưu thông khí huyết, sát trùng, sát khuẩn, cải thiện độ mỡ trong máu, tăng cường sức đề kháng để phòng chống nhiều loại bệnh khác nhau bao gồm các chứng cảm cúm :\n" +
                                                "+ Hàng ngày có thể dùng tỏi để pha nước chấm hoặc trộn rau giúp phòng ngừa cảm cúm.\n" + "+ Trong những đợt dịch cúm có thể sử dụng dung dịch tỏi pha loãng nhỏ mũi giúp ngừa cúm và ngặn chặn một số chứng nhiễm trùng hoặc các loại bệnh lây lan qua đường hô hấp: Giã nát 3 tép tỏi, hãm trong 50g nước sôi khoảng nửa giờ, chắt lấy nước, nhỏ vào mũi mỗi bên khoảng 2 hay 3 giọt, ngày 2 hoặc 3 lần.\n" + "+ Cũng có thể hít hơi tỏi qua mũi sau khi đun sôi khoảng 200g tỏi giã nát trong 300cc nước khoảng 10 phút.\n" + "+ Hít thở sâu khi nước tỏi còn nóng thông qua 1 cái phễu úp trên miệng ấm khi vừa bắt xuống. Độ nóng và hít sâu vừa với khả năng chịu đựng của cơ thể để tránh bị phỏng.\n" +
                                                "\n" +
                                                "• Sữa chua: Sữa chua giàu calcium, và những chất đạm dễ tiêu hóa giúp cân bằng hệ vi sinh đường ruột. Sữa chua đặc biệt tốt cho người già, trẻ em và những người bị cảm cúm.\n" +
                                                "\n" +
                                                "• Các loại cá, hải sản, nhất là hàu, ốc: Ngoài những loại chất đạm và chất béo hữu ích, những loại thực phảm này đặc biệt là hàu, có hàm lượng rất cao khoáng chất kẽm, yếu tố cần thiết cho việc sản xuất và hoạt hoá những tế bào của hệ miễn dịch. Không chỉ kẽm, những loại hải sản này còn có hàm lượng cao selenium, một chất chống oxy hoá mạnh. Selenium cũng có tác dụng kích thích hoạt động củahệ miễn nhiễm giúp cơ thể chống chọi tốt hơn với bệnh cảm cúm.\n" +
                                                "\n" +
                                                "• Rau và hoa quả có màu xanh đậm, đỏ, vàng: Rau quả vừa giúp thanh lọc cơ thể vừa tăng cường tính kiềm để ổn định độ PH giúp duy trì khả năng bình thường của chức năng miễn dịch. Đặc biệt, các loại rau quả sậm màu, màu vàng, màu đỏ như các loại rau xanh, khoai lang, bí đỏ, cà rốt, bông bí, bầu, quả gấc, nho tím, dâu tây . . có hàm lượng cao những sinh tố C, A, chất beta caroten và nhiều hợp chất chất chống oxy hoá khác có khả năng trung hoà những gốc tự do, bảo vệ màng tế bào giúp tăng cường sức đề kháng, chống chọi với bệnh tật tốt hơn.\n" +
                                                "\n" +
                                                "• Rong biển: rong biển chứa hàm lượng vi chất dinh dưỡng, khoáng chất, chất đạm dễ chuyển hóa rất cao, rong biển còn có nhiều sinh tố A và những carotenoids là những chất chống oxy hóa mạnh có tác dụng kháng viêm, bảo vệ màng tế bào. Những polysaccharides trong rong biển có tác dụng tăng cường tính miễn dịch và nâng cao sức chịu đựng của cơ thể đối với những thay đổi của môi trường.\n" +
                                                "\n" +
                                                "• Hạnh nhân: Hạnh nhân chứa hàm lượng vitamin E cao, giàu chất chống oxy hóa giúp tăng cường hệ miễn dịch chống lại bệnh cảm cúm.\n" +
                                                "\n" +
                                                "• Sô-cô-la đen: Lượng cacao đen trong sô-cô-la đen hỗ trợ sự tăng trưởng của các tế bào T và gia tăng hệ miễn dịch của cơ thể chống lại nhiễm trùng. Thêm một lượng so-co-la vừa phải trong món tráng miệng mỗi ngày giúp tăng cường hệ miễn dịch phòng chống bệnh cảm cúm.")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();
                        break;
                    case "4":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("     ★ Người Tập Gym ★")
                                .setMessage("✪ Người tập thể hình không thể bỏ qua tất cả các bữa ăn chính. Đặc biệt ăn sáng lại càng quan trọng hơn. Một bữa sáng lành mạnh, đầy đủ chất sẽ giúp bạn có tinh thần phấn chấn và có đủ năng lượng cho cả ngày làm việc, giảm nguy cơ mắc bệnh. Ngoài ra, còn có thêm các bữa ăn phụ giúp nạp đầy đủ các chất dinh dưỡng, giúp việc tăng cơ nhanh rất tốt cho những người muốn tăng cân.\n\n" +
                                        "✪ Bên cạnh đó, uống đủ nước mỗi ngày rất quan trọng, sẽ giúp cơ thể đào thải độc tố, cung cấp nước giúp việc tăng cân nhanh chóng hơn.\n\n" +
                                        "✪ Sự kết hợp giữa chế độ tập gym hợp lý và áp dụng thực đơn tăng cân khoa học là một sự lựa chọn tuyệt vời mang lại kết quả ngoài mong đợi cho bạn. Hãy thực hiện theo thực đơn dưới đây nhé !\n\n" +
                                        "✥ Bữa ăn sáng ✥\n\n" +
                                        "– Bữa chính: Đây là bữa ăn rất quan trọng, hãy cố gắng thực hiện trước 8h sáng nhé :\n" +
                                        "• 1 hủ tiếu(phở) có thịt gà hoặc thịt bò. Hoặc 1 dĩa cơm sườn trứng ốp la (nhớ ăn ít tinh bột thôi, ăn nhiều càng béo đấy)\n" +
                                        "• 1 hộp sữa\n" +
                                        "• 1 quả chuối\n" +
                                        "• Uống nước từ sáng đến 9h(khoảng 300ml)\n" +
                                        "– Bữa phụ:\n" +
                                        "• 1 quả trứng luộc (ăn cả quả đỡ phí lòng đỏ)\n" +
                                        "• 1 xúc xích bò loại trung\n" +
                                        "• 1 quả táo\n" +
                                        "• 1 hộp sữa\n" +
                                        "• Uống nước(khoảng 300ml)\n\n" +
                                        "✥ Bữa ăn trưa ✥\n\n" +
                                        "– Bữa chính: Nên hoàn thành lúc 12h nhé :\n" +
                                        "• Nhà ăn gì thì cứ ăn nấy nhé (hoặc ăn gì tùy ý cho no bụng)\n" +
                                        "• 1 hộp sữa\n" +
                                        "• 1 nướp ép trái cây\n" +
                                        "• Nước lọc (khoảng 300ml)\n" +
                                        "– Bữa phụ: Hoàn thành bữa này trước lúc tập ít nhất 01h\n" +
                                        "• 1 quả trứng luộc (ăn cả quả đỡ phí lòng đỏ)\n" +
                                        "• 1 xúc xích bò loại trung\n" +
                                        "• 2 quả chuối tiêu\n" +
                                        "• 1 hộp sữa\n\n" +
                                        "✥ Bữa ăn tối ✥\n\n" +
                                        "– Bữa chính: Bạn nên hoàn thành trước 19h30 (ăn ít tinh bột thôi, ăn nhiều sẽ tích tụ mỡ bụng nhé)\n" +
                                        "• Ăn cơm gia đình có gì ăn nấy\n" +
                                        "• 1 hộp sữa\n" +
                                        "• 1 quả chuối\n" +
                                        "• Uống nước lọc\n" +
                                        "– Bữa phụ: Hoàn thành bữa này trước lúc đi ngủ ít nhất 1h\n" +
                                        "• 1 quả trứng luộc\n" +
                                        "• 1 hộp sữa\n" +
                                        "• 1 trái táo\n" +
                                        "• Nên ăn cả lòng đỏ: Tránh phí phạm tức ăn và điều nữa nó có thêm chất béo cung cấp năng lượng cho bạn. Chỉ bỏ lòng đỏ khi bạn muốn giảm béo, giảm mỡ, siết cơ.\n" +
                                        "• Không uống quá nhiều nước trong khi luyện tập, nên uống từng ngụm nhỏ …uống nhiều hoặc ngụm lớn làm dạ dày bạn phải hoạt động nhiều hơn, máu loãng hơn nên độ tập trung cho bài tập sẽ kém.\n" +
                                        "Chúc bạn thành công !!!")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();
                        break;
                    case "5":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("     ★ Người ăn kiêng ★")
                                .setMessage("✿ Thực đơn ăn kiêng với hàm lượng protein cao :\n\n" +
                                        "– Đối với những người thừa cân, cách giảm cân nhanh chóng là chọn cho mình những thực đơn ăn kiêng giàu protein, chất đạm như trứng, thịt nạc,..\n" +
                                        "• Bữa sáng: 2 quả trứng gà luộc, 1 miếng bánh mì lát, 1 ly nước ép trái cây tươi nguyên chất.\n" +
                                        "• Bữa trưa: 1 chén cơm, 1 miếng thịt gà luộc (đùi hoặc ức gà), 1 đĩa rau luộc, 1 bát canh lớn, thêm ½ quả bưởi.\n" +
                                        "• Bữa tối: ½ chén cơm (hoặc không ăn cơm), 1 miếng cá hấp lớn, 1 bát canh lớn, 1 quả táo.\n" +
                                        "• Bữa phụ trong ngày và trước khi đi ngủ: bạn chọn salad trái cây hoặc rau xanh thêm chút dầu oliu hoặc dầu dừa vào trộn, nước ép hoặc sinh tố trái cây nguyên chất hỗn hợp.\n\n" +
                                        "✿ Thực đơn ăn kiêng chất béo cao :\n\n" +
                                        "– Những loại chất béo ở đây được đề cập là những chất béo lành mạnh như dầu oliu, dầu cá, dầu dừa, dầu vừng,.. để thêm vào các món ăn hoặc xào nấu trong quá trình chế biến món ăn cho thực đơn ăn kiêng giảm cân.\n" +
                                        "• Bữa sáng: một ít thịt nướng và trứng gà, khoảng 28g phô-mai, trà sữa hoặc cà phê sữa.\n" +
                                        "• Bữa trưa : có bánh mì nướng, có thể thêm 1 lát thịt nướng, một ít phô-mai và cà chua sống, 1 trái dưa leo, trà không đường.\n" +
                                        "• Bữa tối: gồm cá nướng, một nửa chén salad gồm rau, thịt nướng xắt nhỏ và một ít bơ, dùng thức uống không đường.\n\n" +
                                        "✿ Thực đơn ăn kiêng giàu chất xơ, vitamin và khoáng chất:\n\n" +
                                        "– Đây được coi là một thực đơn giảm cân thanh đạm và nghèo dinh dưỡng nhất. Tuy nhiên bạn có thể áp dụng trong một thời gian nhất định để quá trình giảm cân nhanh hơn, phòng ngừa các bệnh liên quan đến béo phì. Và sau quá trình giảm cân thành công bạn có thể trở lại thực đơn ăn uống bình thường và nên áp dụng 2 ngày/tuần với thực đơn ăn kiêng này.Rau xanh, các loại củ, trái cây tươi,..là những thực phẩm chính bạn chọn cho thực đơn ăn kiêng giảm cân này. Các nhóm thực phẩm này chứa nhiều đạm thực vật, giúp gan và dạ dày thải được chất độc, tăng cường sự trao đổi chất, đốt cháy lượng mỡ thừa, giúp no lâu do lượng đường trong máu tăng cao. Ăn kiêng theo cách này, cơ thể sẽ hấp thu rất ít calori, vì vậy trong 1 tuần có thể giảm 1-2 kg.\n" +
                                        "• Bữa sáng: 1 ly sinh tố, 1 quả chuối, 1 quả cam, 1 tách nước quả nho, 1 bát canh bắp cải. (lựa chọn 2 trong các món).\n" +
                                        "• Bữa trưa 1: phần salad, chú ý ăn nhiều rau tươi có màu xanh, có thể ăn thêm vài miếng gà nướng không mỡ, ăn nhiều canh bắp cải.\n" +
                                        "• Bữa tối: dùng khoảng 150 g cá, cố gắng ăn thêm càng nhiều canh bắp cải càng tốt.\n\n" +
                                        "")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();
                        break;
                    case "6":
                        new AlertDialog.Builder(WelcomeActivity.activity)
                                .setTitle("     ★ Người Tăng Cân ★")
                                .setMessage("– Muốn tăng cân hiệu quả, không chỉ cần bổ sung đủ lượng mà chúng ta còn phải bổ sung đủ chất, có các nhóm thực phẩm tối thiểu không thể bỏ qua: tinh bột, chất đạm, chất béo, vitamin và các loại khoáng chất" +
                                        ".\n – Bên cạnh đó các nhóm thực phẩm bổ sung chất xơ và chất chống oxy hóa cũng cần được bổ sung đầy đủ để hỗ trợ quá trình tiêu hóa.\n\n" +
                                        "• Các loại thịt nên bổ sung: thịt bò, thịt lợn, thịt gia cầm, thịt thỏ… bên cạnh đó cũng nên bổ sung các loại hải sản như tôm, cua, sò, ốc và các chế phẩm từ sữa như: sữa tươi, sữa chua, váng sữa, bơ…\n\n" +
                                        "• Các loại rau củ: khoai tây, cà rốt, bí đỏ, các loại rau xanh…\n\n" +
                                        "• Các loại trái cây: Bơ, chuối, mãng cầu, xoài, hồng xiêm…\n\n" +
                                        "• Thực đơn tăng cân mỗi ngày cần đảm bảo 500calo dưỡng chất cho cơ thể. Bổ sung thực phẩm 1 cách từ từ, không nên vội vàng.\n\n" +
                                        "• Đừng nghĩ rằng thực ăn nhanh và các món ăn chứa nhiều dầu mỡ sẽ giúp bạn tăng cân mà ngốn chúng quá nhiều nhé. Chế độ ăn uống thiếu lành mạnh sẽ có thể làm bạn mắc thêm nhiều bệnh đấy.\n\n" +
                                        "• Chia nhỏ bữa ăn để không gây cảm giác ngán, giúp cơ thể hấp thu dưỡng chất một cách hiệu quả hơn. Mỗi ngày nên ăn 3 bữa chính và 2 đến 3 bữa ăn phụ để giúp cân nặng tăng nhanh chóng hơn.\n\n" +
                                        "• Bên cạnh chế độ ăn uống, bạn cũng cần tập luyện và nghỉ ngơi hợp lý hàng ngày để có được hiệu quả tốt nhất !!!")
                                .setIcon(android.R.drawable.ic_popup_reminder)
                                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }

                                }).show();
                        break;
                }
            }
        };
    }
}

package com.example.yucalorie.food;

import com.example.yucalorie.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class FootDataActivity extends Activity {

	ListView mListView;
	FootAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.food_list);
		AdapterInit();
		ImageButton backButton=(ImageButton)this.findViewById(R.id.foot_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FootDataActivity.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}
	
	private void AdapterInit()
	{
		if(mListView==null)
			mListView=(ListView)this.findViewById(R.id.food_listview);
		if(mAdapter==null)
		{
			
			mAdapter=new FootAdapter(this);
			Intent intent = this.getIntent();
			TextView captionTextView=(TextView)this.findViewById(R.id.foot_caption);
			captionTextView.setText(intent.getStringExtra("caption"));
			int typeid=intent.getIntExtra("type", 0);
			
			switch (typeid) {
			case 0:
				Add_ZaoCan();
				break;
			case 1:
				Add_MianBao();
				break;
			case 2:
				Add_WuGu();
				break;
			case 3:
				Add_ShuiGuo();
				break;
			case 4:
				Add_ShuCai();
				break;
			case 5:
				Add_LingShi();
				break;
			case 6:
				Add_BingGan();
				break;
			case 8:
				Add_XueGao();
				break;
			case 9:
				Add_Tang();
				break;
			case 10:
				Add_GanGuo();
				break;
			case 11:
				Add_Nai();
				break;
			case 12:
				Add_YinLiao();
				break;
			case 13:
				Add_PiJiu();
				break;
			case 14:
				Add_ZhuShi();
				break;
			case 15:
				Add_CaiYao();
				break;
			case 16:
				Add_TiaoWei();
				break;
			default:
				break;
			}
			
			mListView.setAdapter(mAdapter);
		}
	}
	
	private void Add_ZaoCan()
	{
		mAdapter.AddNewItem(new FootItem("炒肝", 96));
		mAdapter.AddNewItem(new FootItem("豆汁", 10));
		mAdapter.AddNewItem(new FootItem("煎饺", 289));
		mAdapter.AddNewItem(new FootItem("豆腐脑(带卤)", 47));
		mAdapter.AddNewItem(new FootItem("猪肝(卤煮)", 203));
		mAdapter.AddNewItem(new FootItem("榨菜", 29));
		mAdapter.AddNewItem(new FootItem("鸡蛋", 114));
		mAdapter.AddNewItem(new FootItem("馄饨", 181));
		mAdapter.AddNewItem(new FootItem("白粥(米：水=1：5)", 32));
		mAdapter.AddNewItem(new FootItem("豆浆", 14));
		mAdapter.AddNewItem(new FootItem("鸡蛋灌饼", 261));
		mAdapter.AddNewItem(new FootItem("油条", 386));
		mAdapter.AddNewItem(new FootItem("煎饼", 336));
		mAdapter.AddNewItem(new FootItem("鲜奶", 163,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("脱脂奶", 88,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("鸡蛋", 75,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("蛋黄", 60,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("蛋白", 15,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("煎蛋", 105,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("玉米", 107,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("小笼包", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("肉包子", 250,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("水饺", 42,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("菜包", 200,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("咖喱饺", 245,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("猪肉水饺", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("蛋饼", 255,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("豆沙包", 215,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("鲜肉包", 225,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("叉烧包", 160,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("即食脆香米", 396));
		mAdapter.AddNewItem(new FootItem("家乐氏全麦维", 264));
		mAdapter.AddNewItem(new FootItem("家乐氏可可片", 388));
		mAdapter.AddNewItem(new FootItem("家乐氏玉米片", 365));
		mAdapter.AddNewItem(new FootItem("家乐氏香甜玉米片", 385));
		mAdapter.AddNewItem(new FootItem("家乐氏葡萄麦维", 305));
		mAdapter.AddNewItem(new FootItem("家乐氏卜卜米", 377));
		mAdapter.AddNewItem(new FootItem("家乐氏杂锦果麦:葡萄乾果仁", 364,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("家乐氏杂锦果麦:苹果及果仁", 383,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("桂格燕麦方脆", 386));
		mAdapter.AddNewItem(new FootItem("牛奶麦皮", 67));
		mAdapter.AddNewItem(new FootItem("燕麦片", 367));
	}
	//面包
	private void Add_MianBao()
	{
		mAdapter.AddNewItem(new FootItem("甜面包", 210,60));
		mAdapter.AddNewItem(new FootItem("咸面包", 170,60));
		mAdapter.AddNewItem(new FootItem("白方包", 290));
		mAdapter.AddNewItem(new FootItem("麦方包", 270));
		mAdapter.AddNewItem(new FootItem("小麦餐包", 273));
		mAdapter.AddNewItem(new FootItem("法式面包", 277));
		mAdapter.AddNewItem(new FootItem("麦面包", 260));
		mAdapter.AddNewItem(new FootItem("白面包", 267));
		mAdapter.AddNewItem(new FootItem("全麦面包", 305));
		mAdapter.AddNewItem(new FootItem("黑麦面包", 259));
		mAdapter.AddNewItem(new FootItem("椰丝面包", 320));
		mAdapter.AddNewItem(new FootItem("花卷", 217));
		mAdapter.AddNewItem(new FootItem("馒头", 231));
		mAdapter.AddNewItem(new FootItem("油条", 386));
		mAdapter.AddNewItem(new FootItem("西多士/法式吐司", 213));
		mAdapter.AddNewItem(new FootItem("油炸面包粒", 407));
		mAdapter.AddNewItem(new FootItem("提子包/葡萄干面包", 274));
		mAdapter.AddNewItem(new FootItem("裸麦粗面包", 250));
		mAdapter.AddNewItem(new FootItem("白彼德面包", 275));
		mAdapter.AddNewItem(new FootItem("彼德面包", 266));
		mAdapter.AddNewItem(new FootItem("多种谷物面包(包括原粒谷物、七种谷物面包)", 250));
		mAdapter.AddNewItem(new FootItem("鸡蛋面包", 287));
		mAdapter.AddNewItem(new FootItem("牛油面包(黄油)", 329));
		mAdapter.AddNewItem(new FootItem("面包棒", 412));
		mAdapter.AddNewItem(new FootItem("面包糠", 395));
		mAdapter.AddNewItem(new FootItem("麦圈包/贝加包", 275));
		mAdapter.AddNewItem(new FootItem("加蛋制麦圈包", 278));
	}
	//五谷类
	private void Add_WuGu()
	{
		mAdapter.AddNewItem(new FootItem("白饭", 130));
		mAdapter.AddNewItem(new FootItem("白米(含添加营养成分)", 365));
		mAdapter.AddNewItem(new FootItem("白糯米饭", 97));
		mAdapter.AddNewItem(new FootItem("米饭(蒸,米)", 114));
		mAdapter.AddNewItem(new FootItem("稻谷(红)/红米", 344));
		mAdapter.AddNewItem(new FootItem("糯米", 344));
		mAdapter.AddNewItem(new FootItem("糙米饭", 111));
		mAdapter.AddNewItem(new FootItem("燕麦", 389));
		mAdapter.AddNewItem(new FootItem("小米", 358));
		mAdapter.AddNewItem(new FootItem("薏米", 357));
		mAdapter.AddNewItem(new FootItem("大麦", 354));
		mAdapter.AddNewItem(new FootItem("荞麦", 343));
		mAdapter.AddNewItem(new FootItem("玉米/粟米", 106));
		mAdapter.AddNewItem(new FootItem("黄金粟米", 365));
		mAdapter.AddNewItem(new FootItem("熟小米", 119));
		mAdapter.AddNewItem(new FootItem("黑麦", 335));
		mAdapter.AddNewItem(new FootItem("高粱", 339));
		mAdapter.AddNewItem(new FootItem("高粱米", 351));
		mAdapter.AddNewItem(new FootItem("西米", 358));
		mAdapter.AddNewItem(new FootItem("荞麦", 343));
		mAdapter.AddNewItem(new FootItem("小麦", 352));
	}
	//水果
	private void Add_ShuiGuo()
	{
		mAdapter.AddNewItem(new FootItem("苹果", 52));
		mAdapter.AddNewItem(new FootItem("苹果(红富士苹果)", 45));
		mAdapter.AddNewItem(new FootItem("杏", 48));
		mAdapter.AddNewItem(new FootItem("蜜饯杏脯", 329));
		mAdapter.AddNewItem(new FootItem("杏脯乾", 238));
		mAdapter.AddNewItem(new FootItem("牛油果/酪梨/鳄梨", 161));
		mAdapter.AddNewItem(new FootItem("香蕉", 92));
		mAdapter.AddNewItem(new FootItem("杨梅", 28));
		mAdapter.AddNewItem(new FootItem("黑莓", 52));
		mAdapter.AddNewItem(new FootItem("蓝莓", 56));
		mAdapter.AddNewItem(new FootItem("杨桃", 33));
		mAdapter.AddNewItem(new FootItem("甜车厘子/甜樱桃", 72));
		mAdapter.AddNewItem(new FootItem("樱桃/车厘子", 46));
		mAdapter.AddNewItem(new FootItem("海棠果", 73));
		mAdapter.AddNewItem(new FootItem("越橘", 49));
		mAdapter.AddNewItem(new FootItem("欧洲黑加仑子", 63));
		mAdapter.AddNewItem(new FootItem("榴莲", 147));
		mAdapter.AddNewItem(new FootItem("接骨木果", 73));
		mAdapter.AddNewItem(new FootItem("油柑子", 38));
		mAdapter.AddNewItem(new FootItem("无花果", 74));
		mAdapter.AddNewItem(new FootItem("无花果乾", 255));
		mAdapter.AddNewItem(new FootItem("醋栗", 44));
		mAdapter.AddNewItem(new FootItem("葡萄", 43));
		mAdapter.AddNewItem(new FootItem("葡萄乾", 341));
		mAdapter.AddNewItem(new FootItem("柚子", 41));
		mAdapter.AddNewItem(new FootItem("西柚", 32));
		mAdapter.AddNewItem(new FootItem("番石榴", 41));
		mAdapter.AddNewItem(new FootItem("番石榴酱", 36));
		mAdapter.AddNewItem(new FootItem("山楂/红果", 95));
		mAdapter.AddNewItem(new FootItem("大树菠萝", 94));
		mAdapter.AddNewItem(new FootItem("鲜枣", 122));
		mAdapter.AddNewItem(new FootItem("蜜枣", 321));
		mAdapter.AddNewItem(new FootItem("乾枣", 287));
		mAdapter.AddNewItem(new FootItem("奇异果/中华獮猴桃", 61));
		mAdapter.AddNewItem(new FootItem("金桔", 55));
		mAdapter.AddNewItem(new FootItem("金橘", 63));
		mAdapter.AddNewItem(new FootItem("柠檬", 35));
		mAdapter.AddNewItem(new FootItem("青柠", 30));
		mAdapter.AddNewItem(new FootItem("荔枝", 66));
		mAdapter.AddNewItem(new FootItem("鲜龙眼/鲜桂圆", 70));
		mAdapter.AddNewItem(new FootItem("龙眼", 60));
		mAdapter.AddNewItem(new FootItem("龙眼乾", 286));
		mAdapter.AddNewItem(new FootItem("枇杷", 39));
		mAdapter.AddNewItem(new FootItem("芒果", 65));
		mAdapter.AddNewItem(new FootItem("哈密瓜", 34));
		mAdapter.AddNewItem(new FootItem("桃驳梨", 49));
		mAdapter.AddNewItem(new FootItem("橄榄(白榄)", 49));
		mAdapter.AddNewItem(new FootItem("橙", 47));
		mAdapter.AddNewItem(new FootItem("柑", 39));
		mAdapter.AddNewItem(new FootItem("木瓜", 39));
		mAdapter.AddNewItem(new FootItem("桃", 43));
		mAdapter.AddNewItem(new FootItem("梨", 32));
		mAdapter.AddNewItem(new FootItem("柿子", 71));
		mAdapter.AddNewItem(new FootItem("柿饼", 250));
		mAdapter.AddNewItem(new FootItem("李子", 55));
		mAdapter.AddNewItem(new FootItem("石榴", 63));
		mAdapter.AddNewItem(new FootItem("西梅乾", 239));
		mAdapter.AddNewItem(new FootItem("覆盆子/乐士啤梨/蔗莓/桑子", 49));
		mAdapter.AddNewItem(new FootItem("杨桃", 29));
		mAdapter.AddNewItem(new FootItem("黄皮", 31));
		mAdapter.AddNewItem(new FootItem("西瓜", 25));
		mAdapter.AddNewItem(new FootItem("火龙果", 51));
		mAdapter.AddNewItem(new FootItem("甘蔗", 64));
	}
	//蔬菜
	private void Add_ShuCai()
	{
		mAdapter.AddNewItem(new FootItem("葱", 47));
		mAdapter.AddNewItem(new FootItem("洋葱", 35));
		mAdapter.AddNewItem(new FootItem("大蒜", 40));
		mAdapter.AddNewItem(new FootItem("马蹄", 68));
		mAdapter.AddNewItem(new FootItem("白菜", 17));
		mAdapter.AddNewItem(new FootItem("通菜", 20));
		mAdapter.AddNewItem(new FootItem("大芥菜", 47));
		mAdapter.AddNewItem(new FootItem("苋菜", 40));
		mAdapter.AddNewItem(new FootItem("芦笋", 15));
		mAdapter.AddNewItem(new FootItem("荷兰豆", 32));
		mAdapter.AddNewItem(new FootItem("青椒", 14));
		mAdapter.AddNewItem(new FootItem("西芹", 5));
		mAdapter.AddNewItem(new FootItem("苦瓜", 12));
		mAdapter.AddNewItem(new FootItem("菜心", 20));
		mAdapter.AddNewItem(new FootItem("美国南瓜", 73));
		mAdapter.AddNewItem(new FootItem("日本南瓜", 35));
		mAdapter.AddNewItem(new FootItem("菠菜", 19));
		mAdapter.AddNewItem(new FootItem("芽菜", 20));
		mAdapter.AddNewItem(new FootItem("雪菜", 60));
		mAdapter.AddNewItem(new FootItem("豆苗", 40));
		mAdapter.AddNewItem(new FootItem("西红柿", 14));
		mAdapter.AddNewItem(new FootItem("青瓜", 12));
		mAdapter.AddNewItem(new FootItem("茄子", 26));
		mAdapter.AddNewItem(new FootItem("丝瓜", 17));
		mAdapter.AddNewItem(new FootItem("冬瓜", 40));
		mAdapter.AddNewItem(new FootItem("芋头", 94));
		mAdapter.AddNewItem(new FootItem("莲藕", 52));
		mAdapter.AddNewItem(new FootItem("海带", 36));
		mAdapter.AddNewItem(new FootItem("草菇(罐头)", 30));
		mAdapter.AddNewItem(new FootItem("青萝卜", 23));
		mAdapter.AddNewItem(new FootItem("白萝卜", 20));
		mAdapter.AddNewItem(new FootItem("西兰花", 28));
		mAdapter.AddNewItem(new FootItem("椰菜", 21));
		mAdapter.AddNewItem(new FootItem("生菜", 10));
		mAdapter.AddNewItem(new FootItem("甘荀", 43));
		mAdapter.AddNewItem(new FootItem("粟米", 107));
		mAdapter.AddNewItem(new FootItem("青豆", 117));
		mAdapter.AddNewItem(new FootItem("蕃薯", 105));
		mAdapter.AddNewItem(new FootItem("熟眉豆", 115));
		mAdapter.AddNewItem(new FootItem("熟红豆", 81));
		mAdapter.AddNewItem(new FootItem("熟黄豆", 173));
		mAdapter.AddNewItem(new FootItem("熟豆腐", 75));
		mAdapter.AddNewItem(new FootItem("熟豆腐泡", 316));
		mAdapter.AddNewItem(new FootItem("薯仔", 80));
	}
	//零食
	private void Add_LingShi()
	{
		mAdapter.AddNewItem(new FootItem("椰丝", 150,25));
		mAdapter.AddNewItem(new FootItem("蛋糕片", 230,60));
		mAdapter.AddNewItem(new FootItem("薯片", 520));
		mAdapter.AddNewItem(new FootItem("芝士圈", 500));
		mAdapter.AddNewItem(new FootItem("仙贝", 35,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("日式豆沙馅糯米", 142,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("红豆大福", 113,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("栗茸饼", 155,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("草饼", 110,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("低脂乳酪", 80,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("纯味乳酪", 160,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("牛丸", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("牛肉乾", 162,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("猪肉乾", 95,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("卡夫芝士", 63,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("油角", 130,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("臭豆腐", 370,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("碗仔翅", 240,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("粟米粒", 120,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("鱼蛋", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("葡挞", 320,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("凤梨酥", 300,50));
		mAdapter.AddNewItem(new FootItem("豆干块", 150,60));
		mAdapter.AddNewItem(new FootItem("花生米", 560));
		mAdapter.AddNewItem(new FootItem("鱿鱼丝", 230,80));
		mAdapter.AddNewItem(new FootItem("鱿鱼片", 259,80));
		mAdapter.AddNewItem(new FootItem("鳕鱼丝", 250,50));
		mAdapter.AddNewItem(new FootItem("紫菜", 335));
		mAdapter.AddNewItem(new FootItem("辣味紫菜", 25,7));
		mAdapter.AddNewItem(new FootItem("芋头片", 504,95));
		mAdapter.AddNewItem(new FootItem("粟米片", 377));
		mAdapter.AddNewItem(new FootItem("牛板筋", 167));
		mAdapter.AddNewItem(new FootItem("爆米花", 387));
	}
	//饼干
	private void Add_BingGan()
	{
		mAdapter.AddNewItem(new FootItem("黑芝麻大豆纤维曲奇", 527));
		mAdapter.AddNewItem(new FootItem("蓝罐曲奇", 525));
		mAdapter.AddNewItem(new FootItem("全麦营养饼", 537));
		mAdapter.AddNewItem(new FootItem("EDO天然营养麦饼", 508));
		mAdapter.AddNewItem(new FootItem("时兴隆高纤全麦饼", 493));
		mAdapter.AddNewItem(new FootItem("Fancl House减肥饼", 493));
		mAdapter.AddNewItem(new FootItem("百荣胚芽高纤饼", 491));
		mAdapter.AddNewItem(new FootItem("嘉顿麦苏打饼", 477));
		mAdapter.AddNewItem(new FootItem("Westons Ryvita麦饼", 368));
		mAdapter.AddNewItem(new FootItem("Arnott's Vita-Weat", 383));
		mAdapter.AddNewItem(new FootItem("President's Choice香脆烘饼", 371));
		mAdapter.AddNewItem(new FootItem("四洲高纤全麦饼", 409));
		mAdapter.AddNewItem(new FootItem("大可香脆苏", 496));
		mAdapter.AddNewItem(new FootItem("愉快动物饼(紫菜味)", 151));
		mAdapter.AddNewItem(new FootItem("Collon朱古力忌廉卷", 516));
		mAdapter.AddNewItem(new FootItem("克力架", 32,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("熊仔饼", 334));
		mAdapter.AddNewItem(new FootItem("百力支", 190,25));
	}
	//雪糕
	private void Add_XueGao()
	{
		mAdapter.AddNewItem(new FootItem("牛奶公司雪糕", 163,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("Dreyers chocolate chips雪糕", 170,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("奶油曲奇雪糕批", 250,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("云呢拿雪糕", 269,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("果汁雪条", 57,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("炭烧咖啡雪条", 147,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("甜筒", 231,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("雪糕糯米", 70,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("雪糕/冰淇淋", 126));
		mAdapter.AddNewItem(new FootItem("雪糕砖/雪糕批/冰砖", 153));
		mAdapter.AddNewItem(new FootItem("鲜果及果汁雪条", 86));
		mAdapter.AddNewItem(new FootItem("朱古力雪糕/巧克力冰淇淋", 216));
		mAdapter.AddNewItem(new FootItem("法式云呢拿软雪糕/法式香草软冰淇淋", 215));
		mAdapter.AddNewItem(new FootItem("云呢拿雪糕/香草冰淇淋", 201));
		mAdapter.AddNewItem(new FootItem("菠萝椰子冰", 113));
		mAdapter.AddNewItem(new FootItem("香橙雪葩", 138));
	}
	//糖果
	private void Add_Tang()
	{
		mAdapter.AddNewItem(new FootItem("牛油糖", 105,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("棉花糖", 80,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("果汁糖", 265,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("瑞士糖", 22,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("特选牛乳糖", 19,1,R.string.name_unit_li));
	}
	//干果
	private void Add_GanGuo()
	{
		mAdapter.AddNewItem(new FootItem("瓜子(白、红、黑)", 4,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("腰果", 160,15,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("花生", 170,40,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("核桃", 160,7,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("杏仁", 170,30,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("松子果仁", 175,30));
		mAdapter.AddNewItem(new FootItem("提子乾", 40,15));
		mAdapter.AddNewItem(new FootItem("龙眼乾", 42,15));
		mAdapter.AddNewItem(new FootItem("开心果", 653,50));
		mAdapter.AddNewItem(new FootItem("蜜糖腰果", 680));
		mAdapter.AddNewItem(new FootItem("葡萄乾", 284));
		mAdapter.AddNewItem(new FootItem("芒果乾", 120));
		mAdapter.AddNewItem(new FootItem("焗花生", 68,28,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("焗栗子", 98,3,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("炸蚕豆", 446));
	}
	//奶类
	private void Add_Nai()
	{
		mAdapter.AddNewItem(new FootItem("全脂牛奶", 150,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("低脂牛奶", 121,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("脱脂牛奶", 91,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("全脂朱古力奶", 205,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("炼奶6茶匙", 123,32));
		mAdapter.AddNewItem(new FootItem("全脂淡奶6茶匙", 42,32));
		mAdapter.AddNewItem(new FootItem("朱古力奶昔", 360,283,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("云呢拿奶昔", 314,283,R.string.name_unit_ml));
	}
	//饮料
	private void Add_YinLiao()
	{
		mAdapter.AddNewItem(new FootItem("清茶", 2,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("益力多", 70,100,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("维他奶", 120,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("葡萄适1细樽", 198,275,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("利宾纳", 160,70,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("甜豆浆", 120,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("菊花茶", 90,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("纯橙汁", 114,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("好立克(2满茶匙)", 59,15,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("阿华田(2满茶匙)", 26,7,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("谷古粉(2满茶匙)", 19,6,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("番茄汁", 35,190,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("蔬菜汁", 35,190,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("斋咖啡", 2,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("无糖乌龙茶", 0,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("无糖麦茶", 0,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("沙士", 126,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("鲜榨橙汁", 212,460,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("鲜榨果汁", 142,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("鲜榨提子汁", 141,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("冰红茶", 120,300,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("泡沫绿茶", 110,300,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("可乐", 150,355,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("健怡可乐", 4,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("雪碧", 147,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("百事可乐", 161,350,R.string.name_unit_ml));
	}
	//啤酒
	private void Add_PiJiu()
	{
		mAdapter.AddNewItem(new FootItem("燕京啤酒", 145,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("雪花啤酒", 140,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("朝日生啤", 144,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("麒麟啤酒", 151,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("百威啤酒", 142,335,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("威士忌", 70,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("梅酒(连梅)", 71,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("伏特加", 100,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("血腥玛莉", 123,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("罐装夏威夷风情鸡尾酒", 237));
		mAdapter.AddNewItem(new FootItem("罐装柠檬威士忌鸡尾酒 ", 119));
		mAdapter.AddNewItem(new FootItem("无甜味餐后酒", 126));
		mAdapter.AddNewItem(new FootItem("餐后甜酒", 153));
		mAdapter.AddNewItem(new FootItem("红餐酒", 72));
		mAdapter.AddNewItem(new FootItem("玫瑰餐酒", 71));
		mAdapter.AddNewItem(new FootItem("白餐酒", 68));
	}
	//主食
	private void Add_ZhuShi()
	{
		mAdapter.AddNewItem(new FootItem("咖喱饭", 640,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("什锦炒饭", 800,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("什锦披萨", 260,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("阳春面", 392,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("牛肉面", 540,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("意大利面", 600,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("什锦炒面", 860,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("榨菜肉丝面", 400,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("炸酱面", 385,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("焗海鲜", 357,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("火腿饭", 690,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("烤白菜", 149,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("炸肉片", 302,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("牛肉蔬菜汤", 362,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("热狗煲", 263,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("什锦蛋包", 227,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("鸡肉饭", 713,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("海鲜汤", 192,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("排骨饭面", 480,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("混沌面", 560,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("肉丝面", 440,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("方便面", 470,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("白饭", 210,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("白馒头", 280,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("煎饼", 333));
		mAdapter.AddNewItem(new FootItem("馒头", 233));
		mAdapter.AddNewItem(new FootItem("花卷", 217));
		mAdapter.AddNewItem(new FootItem("小笼包", 200,5,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("肉包子", 250,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("水饺", 420,10,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("菜包", 200,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("咖喱饺", 245,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("猪肉水饺", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("豆沙包", 215,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("蛋饼", 255,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("鲜肉包", 280,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("叉烧包", 160,5,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("小水煎包", 110,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("韭菜盒子", 260,10,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("春卷", 463));
		mAdapter.AddNewItem(new FootItem("烧饼", 326));
		mAdapter.AddNewItem(new FootItem("油条", 230,1,R.string.name_unit_ge));
	}
	//菜肴
	private void Add_CaiYao()
	{
		mAdapter.AddNewItem(new FootItem("花生豆花", 180,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("三鲜豆皮", 240));
		mAdapter.AddNewItem(new FootItem("烧麦", 238));
		mAdapter.AddNewItem(new FootItem("汤包", 238));
		mAdapter.AddNewItem(new FootItem("烙饼", 225));
		mAdapter.AddNewItem(new FootItem("白水洋头", 193));
		mAdapter.AddNewItem(new FootItem("艾窝窝", 190));
		mAdapter.AddNewItem(new FootItem("白吐司", 130));
		mAdapter.AddNewItem(new FootItem("米粉汤", 185));
		mAdapter.AddNewItem(new FootItem("粉丝", 335));
		mAdapter.AddNewItem(new FootItem("粉皮", 64));
		mAdapter.AddNewItem(new FootItem("凉粉", 37));
		mAdapter.AddNewItem(new FootItem("粉条", 336));
		mAdapter.AddNewItem(new FootItem("肉羹米粉", 350,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("米粉汤", 185,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("炒米粉", 275,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("广东粥", 400,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("皮蛋瘦肉粥", 367,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("鱼肉饭团", 205,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("腐竹皮", 489));
		mAdapter.AddNewItem(new FootItem("腐竹", 489));
		mAdapter.AddNewItem(new FootItem("豆腐皮", 409));
		mAdapter.AddNewItem(new FootItem("桂林腐乳", 204));
		mAdapter.AddNewItem(new FootItem("豆腐丝", 201));
		mAdapter.AddNewItem(new FootItem("熏干", 153));
		mAdapter.AddNewItem(new FootItem("酱豆腐", 151));
		mAdapter.AddNewItem(new FootItem("香干", 147));
		mAdapter.AddNewItem(new FootItem("豆腐干", 140));
		mAdapter.AddNewItem(new FootItem("上海南乳", 138));
		mAdapter.AddNewItem(new FootItem("菜干", 68));
		mAdapter.AddNewItem(new FootItem("腐乳", 133));
		mAdapter.AddNewItem(new FootItem("臭豆腐", 130));
		mAdapter.AddNewItem(new FootItem("北豆腐", 98));
		mAdapter.AddNewItem(new FootItem("南豆腐", 57));
		mAdapter.AddNewItem(new FootItem("酸豆乳", 67));
		mAdapter.AddNewItem(new FootItem("白薯干", 612));
		mAdapter.AddNewItem(new FootItem("土豆粉", 337));
		mAdapter.AddNewItem(new FootItem("地瓜粉", 336));
		mAdapter.AddNewItem(new FootItem("大麦", 307));
		mAdapter.AddNewItem(new FootItem("白薯(白心)", 64));
		mAdapter.AddNewItem(new FootItem("白薯(红心)", 99));
		mAdapter.AddNewItem(new FootItem("豆腐脑(带卤)", 47));
		mAdapter.AddNewItem(new FootItem("豆汁", 10));
		mAdapter.AddNewItem(new FootItem("绿豆凸", 320,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("红豆馅", 274));
		mAdapter.AddNewItem(new FootItem("炒肝", 96));
		mAdapter.AddNewItem(new FootItem("油茶", 94));
		mAdapter.AddNewItem(new FootItem("茶汤", 92));
		mAdapter.AddNewItem(new FootItem("小豆粥", 61));
		mAdapter.AddNewItem(new FootItem("羊肉串", 62,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("猪血糕", 130,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("鱼板", 60,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("玉米棒", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("油豆腐", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("贡九串", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("香菇丸", 90,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("蛋丸", 90,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("多拿滋", 70,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("鸡香卷", 70,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("龙虾棒", 95,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("五味丸", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("猪肉(血脖)", 640));
		mAdapter.AddNewItem(new FootItem("猪肉(肋条肉)", 591));
		mAdapter.AddNewItem(new FootItem("猪肉(软五花)", 410));
		mAdapter.AddNewItem(new FootItem("猪肉(硬五花)", 429));
		mAdapter.AddNewItem(new FootItem("猪肉(前蹄膀)", 504));
		mAdapter.AddNewItem(new FootItem("牛肉", 106));
		mAdapter.AddNewItem(new FootItem("牛肚", 72));
		mAdapter.AddNewItem(new FootItem("牛肉松", 445));
		mAdapter.AddNewItem(new FootItem("牛肉干", 550));
		mAdapter.AddNewItem(new FootItem("鸡胗", 118));
		mAdapter.AddNewItem(new FootItem("扒鸡", 325));
		mAdapter.AddNewItem(new FootItem("烤鸡", 328));
		mAdapter.AddNewItem(new FootItem("鸡肝", 121));
		mAdapter.AddNewItem(new FootItem("鸡心", 172));
		mAdapter.AddNewItem(new FootItem("鸡腿", 262));
		mAdapter.AddNewItem(new FootItem("沙鸡", 358));
		mAdapter.AddNewItem(new FootItem("鸡血", 49));
		mAdapter.AddNewItem(new FootItem("鸡翅膀", 215));
		mAdapter.AddNewItem(new FootItem("鳕鱼", 88));
		mAdapter.AddNewItem(new FootItem("石斑鱼", 561));
		mAdapter.AddNewItem(new FootItem("对虾", 152));
	}

	//啤酒
	private void Add_TiaoWei()
	{
		mAdapter.AddNewItem(new FootItem("酱油", 10,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("沙拉油", 100,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("果酱", 50,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("千岛沙拉酱", 60,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("花生酱", 95,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("芝麻酱", 14,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("辣油豆瓣酱", 180,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("黄酱", 140,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("甜每诳诖", 136,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("辣酱(麻)", 135,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("奶油", 97,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("豆瓣酱", 10,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("白醋", 93,1,R.string.name_unit_shi));
	}

}

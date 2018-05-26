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
		mAdapter.AddNewItem(new FootItem("����", 96));
		mAdapter.AddNewItem(new FootItem("��֭", 10));
		mAdapter.AddNewItem(new FootItem("���", 289));
		mAdapter.AddNewItem(new FootItem("������(��±)", 47));
		mAdapter.AddNewItem(new FootItem("���(±��)", 203));
		mAdapter.AddNewItem(new FootItem("ե��", 29));
		mAdapter.AddNewItem(new FootItem("����", 114));
		mAdapter.AddNewItem(new FootItem("���", 181));
		mAdapter.AddNewItem(new FootItem("����(�ף�ˮ=1��5)", 32));
		mAdapter.AddNewItem(new FootItem("����", 14));
		mAdapter.AddNewItem(new FootItem("�������", 261));
		mAdapter.AddNewItem(new FootItem("����", 386));
		mAdapter.AddNewItem(new FootItem("���", 336));
		mAdapter.AddNewItem(new FootItem("����", 163,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��֬��", 88,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����", 75,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 60,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 15,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�嵰", 105,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 107,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("С����", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�����", 250,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("ˮ��", 42,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�˰�", 200,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ଽ�", 245,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����ˮ��", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 255,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ɳ��", 215,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�����", 225,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("���հ�", 160,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ʳ������", 396));
		mAdapter.AddNewItem(new FootItem("������ȫ��ά", 264));
		mAdapter.AddNewItem(new FootItem("�����Ͽɿ�Ƭ", 388));
		mAdapter.AddNewItem(new FootItem("����������Ƭ", 365));
		mAdapter.AddNewItem(new FootItem("��������������Ƭ", 385));
		mAdapter.AddNewItem(new FootItem("������������ά", 305));
		mAdapter.AddNewItem(new FootItem("�����ϲ�����", 377));
		mAdapter.AddNewItem(new FootItem("�������ӽ�����:����Ǭ����", 364,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�������ӽ�����:ƻ��������", 383,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("������󷽴�", 386));
		mAdapter.AddNewItem(new FootItem("ţ����Ƥ", 67));
		mAdapter.AddNewItem(new FootItem("����Ƭ", 367));
	}
	//���
	private void Add_MianBao()
	{
		mAdapter.AddNewItem(new FootItem("�����", 210,60));
		mAdapter.AddNewItem(new FootItem("�����", 170,60));
		mAdapter.AddNewItem(new FootItem("�׷���", 290));
		mAdapter.AddNewItem(new FootItem("�󷽰�", 270));
		mAdapter.AddNewItem(new FootItem("С��Ͱ�", 273));
		mAdapter.AddNewItem(new FootItem("��ʽ���", 277));
		mAdapter.AddNewItem(new FootItem("�����", 260));
		mAdapter.AddNewItem(new FootItem("�����", 267));
		mAdapter.AddNewItem(new FootItem("ȫ�����", 305));
		mAdapter.AddNewItem(new FootItem("�������", 259));
		mAdapter.AddNewItem(new FootItem("Ҭ˿���", 320));
		mAdapter.AddNewItem(new FootItem("����", 217));
		mAdapter.AddNewItem(new FootItem("��ͷ", 231));
		mAdapter.AddNewItem(new FootItem("����", 386));
		mAdapter.AddNewItem(new FootItem("����ʿ/��ʽ��˾", 213));
		mAdapter.AddNewItem(new FootItem("��ը�����", 407));
		mAdapter.AddNewItem(new FootItem("���Ӱ�/���Ѹ����", 274));
		mAdapter.AddNewItem(new FootItem("��������", 250));
		mAdapter.AddNewItem(new FootItem("�ױ˵����", 275));
		mAdapter.AddNewItem(new FootItem("�˵����", 266));
		mAdapter.AddNewItem(new FootItem("���ֹ������(����ԭ��������ֹ������)", 250));
		mAdapter.AddNewItem(new FootItem("�������", 287));
		mAdapter.AddNewItem(new FootItem("ţ�����(����)", 329));
		mAdapter.AddNewItem(new FootItem("�����", 412));
		mAdapter.AddNewItem(new FootItem("�����", 395));
		mAdapter.AddNewItem(new FootItem("��Ȧ��/���Ӱ�", 275));
		mAdapter.AddNewItem(new FootItem("�ӵ�����Ȧ��", 278));
	}
	//�����
	private void Add_WuGu()
	{
		mAdapter.AddNewItem(new FootItem("�׷�", 130));
		mAdapter.AddNewItem(new FootItem("����(�����Ӫ���ɷ�)", 365));
		mAdapter.AddNewItem(new FootItem("��Ŵ�׷�", 97));
		mAdapter.AddNewItem(new FootItem("�׷�(��,��)", 114));
		mAdapter.AddNewItem(new FootItem("����(��)/����", 344));
		mAdapter.AddNewItem(new FootItem("Ŵ��", 344));
		mAdapter.AddNewItem(new FootItem("���׷�", 111));
		mAdapter.AddNewItem(new FootItem("����", 389));
		mAdapter.AddNewItem(new FootItem("С��", 358));
		mAdapter.AddNewItem(new FootItem("޲��", 357));
		mAdapter.AddNewItem(new FootItem("����", 354));
		mAdapter.AddNewItem(new FootItem("����", 343));
		mAdapter.AddNewItem(new FootItem("����/����", 106));
		mAdapter.AddNewItem(new FootItem("�ƽ�����", 365));
		mAdapter.AddNewItem(new FootItem("��С��", 119));
		mAdapter.AddNewItem(new FootItem("����", 335));
		mAdapter.AddNewItem(new FootItem("����", 339));
		mAdapter.AddNewItem(new FootItem("������", 351));
		mAdapter.AddNewItem(new FootItem("����", 358));
		mAdapter.AddNewItem(new FootItem("����", 343));
		mAdapter.AddNewItem(new FootItem("С��", 352));
	}
	//ˮ��
	private void Add_ShuiGuo()
	{
		mAdapter.AddNewItem(new FootItem("ƻ��", 52));
		mAdapter.AddNewItem(new FootItem("ƻ��(�츻ʿƻ��)", 45));
		mAdapter.AddNewItem(new FootItem("��", 48));
		mAdapter.AddNewItem(new FootItem("�۽��Ӹ�", 329));
		mAdapter.AddNewItem(new FootItem("�Ӹ�Ǭ", 238));
		mAdapter.AddNewItem(new FootItem("ţ�͹�/����/����", 161));
		mAdapter.AddNewItem(new FootItem("�㽶", 92));
		mAdapter.AddNewItem(new FootItem("��÷", 28));
		mAdapter.AddNewItem(new FootItem("��ݮ", 52));
		mAdapter.AddNewItem(new FootItem("��ݮ", 56));
		mAdapter.AddNewItem(new FootItem("����", 33));
		mAdapter.AddNewItem(new FootItem("������/��ӣ��", 72));
		mAdapter.AddNewItem(new FootItem("ӣ��/������", 46));
		mAdapter.AddNewItem(new FootItem("���Ĺ�", 73));
		mAdapter.AddNewItem(new FootItem("Խ��", 49));
		mAdapter.AddNewItem(new FootItem("ŷ�޺ڼ�����", 63));
		mAdapter.AddNewItem(new FootItem("����", 147));
		mAdapter.AddNewItem(new FootItem("�ӹ�ľ��", 73));
		mAdapter.AddNewItem(new FootItem("�͸���", 38));
		mAdapter.AddNewItem(new FootItem("�޻���", 74));
		mAdapter.AddNewItem(new FootItem("�޻���Ǭ", 255));
		mAdapter.AddNewItem(new FootItem("����", 44));
		mAdapter.AddNewItem(new FootItem("����", 43));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 341));
		mAdapter.AddNewItem(new FootItem("����", 41));
		mAdapter.AddNewItem(new FootItem("����", 32));
		mAdapter.AddNewItem(new FootItem("��ʯ��", 41));
		mAdapter.AddNewItem(new FootItem("��ʯ��", 36));
		mAdapter.AddNewItem(new FootItem("ɽ�/���", 95));
		mAdapter.AddNewItem(new FootItem("��������", 94));
		mAdapter.AddNewItem(new FootItem("����", 122));
		mAdapter.AddNewItem(new FootItem("����", 321));
		mAdapter.AddNewItem(new FootItem("Ǭ��", 287));
		mAdapter.AddNewItem(new FootItem("�����/�л�������", 61));
		mAdapter.AddNewItem(new FootItem("���", 55));
		mAdapter.AddNewItem(new FootItem("����", 63));
		mAdapter.AddNewItem(new FootItem("����", 35));
		mAdapter.AddNewItem(new FootItem("����", 30));
		mAdapter.AddNewItem(new FootItem("��֦", 66));
		mAdapter.AddNewItem(new FootItem("������/�ʹ�Բ", 70));
		mAdapter.AddNewItem(new FootItem("����", 60));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 286));
		mAdapter.AddNewItem(new FootItem("����", 39));
		mAdapter.AddNewItem(new FootItem("â��", 65));
		mAdapter.AddNewItem(new FootItem("���ܹ�", 34));
		mAdapter.AddNewItem(new FootItem("�Ҳ���", 49));
		mAdapter.AddNewItem(new FootItem("���(���)", 49));
		mAdapter.AddNewItem(new FootItem("��", 47));
		mAdapter.AddNewItem(new FootItem("��", 39));
		mAdapter.AddNewItem(new FootItem("ľ��", 39));
		mAdapter.AddNewItem(new FootItem("��", 43));
		mAdapter.AddNewItem(new FootItem("��", 32));
		mAdapter.AddNewItem(new FootItem("����", 71));
		mAdapter.AddNewItem(new FootItem("����", 250));
		mAdapter.AddNewItem(new FootItem("����", 55));
		mAdapter.AddNewItem(new FootItem("ʯ��", 63));
		mAdapter.AddNewItem(new FootItem("��÷Ǭ", 239));
		mAdapter.AddNewItem(new FootItem("������/��ʿơ��/��ݮ/ɣ��", 49));
		mAdapter.AddNewItem(new FootItem("����", 29));
		mAdapter.AddNewItem(new FootItem("��Ƥ", 31));
		mAdapter.AddNewItem(new FootItem("����", 25));
		mAdapter.AddNewItem(new FootItem("������", 51));
		mAdapter.AddNewItem(new FootItem("����", 64));
	}
	//�߲�
	private void Add_ShuCai()
	{
		mAdapter.AddNewItem(new FootItem("��", 47));
		mAdapter.AddNewItem(new FootItem("���", 35));
		mAdapter.AddNewItem(new FootItem("����", 40));
		mAdapter.AddNewItem(new FootItem("����", 68));
		mAdapter.AddNewItem(new FootItem("�ײ�", 17));
		mAdapter.AddNewItem(new FootItem("ͨ��", 20));
		mAdapter.AddNewItem(new FootItem("����", 47));
		mAdapter.AddNewItem(new FootItem("�Ȳ�", 40));
		mAdapter.AddNewItem(new FootItem("«��", 15));
		mAdapter.AddNewItem(new FootItem("������", 32));
		mAdapter.AddNewItem(new FootItem("�ཷ", 14));
		mAdapter.AddNewItem(new FootItem("����", 5));
		mAdapter.AddNewItem(new FootItem("���", 12));
		mAdapter.AddNewItem(new FootItem("����", 20));
		mAdapter.AddNewItem(new FootItem("�����Ϲ�", 73));
		mAdapter.AddNewItem(new FootItem("�ձ��Ϲ�", 35));
		mAdapter.AddNewItem(new FootItem("����", 19));
		mAdapter.AddNewItem(new FootItem("ѿ��", 20));
		mAdapter.AddNewItem(new FootItem("ѩ��", 60));
		mAdapter.AddNewItem(new FootItem("����", 40));
		mAdapter.AddNewItem(new FootItem("������", 14));
		mAdapter.AddNewItem(new FootItem("���", 12));
		mAdapter.AddNewItem(new FootItem("����", 26));
		mAdapter.AddNewItem(new FootItem("˿��", 17));
		mAdapter.AddNewItem(new FootItem("����", 40));
		mAdapter.AddNewItem(new FootItem("��ͷ", 94));
		mAdapter.AddNewItem(new FootItem("��ź", 52));
		mAdapter.AddNewItem(new FootItem("����", 36));
		mAdapter.AddNewItem(new FootItem("�ݹ�(��ͷ)", 30));
		mAdapter.AddNewItem(new FootItem("���ܲ�", 23));
		mAdapter.AddNewItem(new FootItem("���ܲ�", 20));
		mAdapter.AddNewItem(new FootItem("������", 28));
		mAdapter.AddNewItem(new FootItem("Ҭ��", 21));
		mAdapter.AddNewItem(new FootItem("����", 10));
		mAdapter.AddNewItem(new FootItem("����", 43));
		mAdapter.AddNewItem(new FootItem("����", 107));
		mAdapter.AddNewItem(new FootItem("�ඹ", 117));
		mAdapter.AddNewItem(new FootItem("ެ��", 105));
		mAdapter.AddNewItem(new FootItem("��ü��", 115));
		mAdapter.AddNewItem(new FootItem("��춹", 81));
		mAdapter.AddNewItem(new FootItem("��ƶ�", 173));
		mAdapter.AddNewItem(new FootItem("�춹��", 75));
		mAdapter.AddNewItem(new FootItem("�춹����", 316));
		mAdapter.AddNewItem(new FootItem("����", 80));
	}
	//��ʳ
	private void Add_LingShi()
	{
		mAdapter.AddNewItem(new FootItem("Ҭ˿", 150,25));
		mAdapter.AddNewItem(new FootItem("����Ƭ", 230,60));
		mAdapter.AddNewItem(new FootItem("��Ƭ", 520));
		mAdapter.AddNewItem(new FootItem("֥ʿȦ", 500));
		mAdapter.AddNewItem(new FootItem("�ɱ�", 35,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ʽ��ɳ��Ŵ��", 142,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�춹��", 113,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("���ױ�", 155,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�ݱ�", 110,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��֬����", 80,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("��ζ����", 160,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("ţ��", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("ţ��Ǭ", 162,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 95,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("����֥ʿ", 63,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("�ͽ�", 130,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("������", 370,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("���г�", 240,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("������", 120,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("�㵰", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("��̢", 320,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("������", 300,50));
		mAdapter.AddNewItem(new FootItem("���ɿ�", 150,60));
		mAdapter.AddNewItem(new FootItem("������", 560));
		mAdapter.AddNewItem(new FootItem("����˿", 230,80));
		mAdapter.AddNewItem(new FootItem("����Ƭ", 259,80));
		mAdapter.AddNewItem(new FootItem("����˿", 250,50));
		mAdapter.AddNewItem(new FootItem("�ϲ�", 335));
		mAdapter.AddNewItem(new FootItem("��ζ�ϲ�", 25,7));
		mAdapter.AddNewItem(new FootItem("��ͷƬ", 504,95));
		mAdapter.AddNewItem(new FootItem("����Ƭ", 377));
		mAdapter.AddNewItem(new FootItem("ţ���", 167));
		mAdapter.AddNewItem(new FootItem("���׻�", 387));
	}
	//����
	private void Add_BingGan()
	{
		mAdapter.AddNewItem(new FootItem("��֥�����ά����", 527));
		mAdapter.AddNewItem(new FootItem("��������", 525));
		mAdapter.AddNewItem(new FootItem("ȫ��Ӫ����", 537));
		mAdapter.AddNewItem(new FootItem("EDO��ȻӪ�����", 508));
		mAdapter.AddNewItem(new FootItem("ʱ��¡����ȫ���", 493));
		mAdapter.AddNewItem(new FootItem("Fancl House���ʱ�", 493));
		mAdapter.AddNewItem(new FootItem("������ѿ���˱�", 491));
		mAdapter.AddNewItem(new FootItem("�ζ����մ��", 477));
		mAdapter.AddNewItem(new FootItem("Westons Ryvita���", 368));
		mAdapter.AddNewItem(new FootItem("Arnott's Vita-Weat", 383));
		mAdapter.AddNewItem(new FootItem("President's Choice�����", 371));
		mAdapter.AddNewItem(new FootItem("���޸���ȫ���", 409));
		mAdapter.AddNewItem(new FootItem("��������", 496));
		mAdapter.AddNewItem(new FootItem("��춯���(�ϲ�ζ)", 151));
		mAdapter.AddNewItem(new FootItem("Collon�����������", 516));
		mAdapter.AddNewItem(new FootItem("������", 32,1,R.string.name_unit_kuai));
		mAdapter.AddNewItem(new FootItem("���б�", 334));
		mAdapter.AddNewItem(new FootItem("����֧", 190,25));
	}
	//ѩ��
	private void Add_XueGao()
	{
		mAdapter.AddNewItem(new FootItem("ţ�̹�˾ѩ��", 163,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("Dreyers chocolate chipsѩ��", 170,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("��������ѩ����", 250,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("������ѩ��", 269,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("��֭ѩ��", 57,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("̿�տ���ѩ��", 147,1,R.string.name_unit_tiao));
		mAdapter.AddNewItem(new FootItem("��Ͳ", 231,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("ѩ��Ŵ��", 70,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("ѩ��/�����", 126));
		mAdapter.AddNewItem(new FootItem("ѩ��ש/ѩ����/��ש", 153));
		mAdapter.AddNewItem(new FootItem("�ʹ�����֭ѩ��", 86));
		mAdapter.AddNewItem(new FootItem("�����ѩ��/�ɿ��������", 216));
		mAdapter.AddNewItem(new FootItem("��ʽ��������ѩ��/��ʽ���������", 215));
		mAdapter.AddNewItem(new FootItem("������ѩ��/��ݱ����", 201));
		mAdapter.AddNewItem(new FootItem("����Ҭ�ӱ�", 113));
		mAdapter.AddNewItem(new FootItem("���ѩ��", 138));
	}
	//�ǹ�
	private void Add_Tang()
	{
		mAdapter.AddNewItem(new FootItem("ţ����", 105,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("�޻���", 80,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("��֭��", 265,5,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("��ʿ��", 22,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("��ѡţ����", 19,1,R.string.name_unit_li));
	}
	//�ɹ�
	private void Add_GanGuo()
	{
		mAdapter.AddNewItem(new FootItem("����(�ס��졢��)", 4,1,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("����", 160,15,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("����", 170,40,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("����", 160,7,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("����", 170,30,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("���ӹ���", 175,30));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 40,15));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 42,15));
		mAdapter.AddNewItem(new FootItem("���Ĺ�", 653,50));
		mAdapter.AddNewItem(new FootItem("��������", 680));
		mAdapter.AddNewItem(new FootItem("����Ǭ", 284));
		mAdapter.AddNewItem(new FootItem("â��Ǭ", 120));
		mAdapter.AddNewItem(new FootItem("�h����", 68,28,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("�h����", 98,3,R.string.name_unit_li));
		mAdapter.AddNewItem(new FootItem("ը�϶�", 446));
	}
	//����
	private void Add_Nai()
	{
		mAdapter.AddNewItem(new FootItem("ȫ֬ţ��", 150,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��֬ţ��", 121,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��֬ţ��", 91,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ȫ֬�������", 205,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����6���", 123,32));
		mAdapter.AddNewItem(new FootItem("ȫ֬����6���", 42,32));
		mAdapter.AddNewItem(new FootItem("���������", 360,283,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����������", 314,283,R.string.name_unit_ml));
	}
	//����
	private void Add_YinLiao()
	{
		mAdapter.AddNewItem(new FootItem("���", 2,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������", 70,100,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ά����", 120,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������1ϸ��", 198,275,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������", 160,70,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("�𶹽�", 120,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("�ջ���", 90,1,R.string.name_unit_bei));
		mAdapter.AddNewItem(new FootItem("����֭", 114,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������(2�����)", 59,15,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������(2�����)", 26,7,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("�ȹŷ�(2�����)", 19,6,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����֭", 35,190,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("�߲�֭", 35,190,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ի����", 2,240,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����������", 0,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("�������", 0,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ɳʿ", 126,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��ե��֭", 212,460,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��ե��֭", 142,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��ե����֭", 141,250,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("�����", 120,300,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��ĭ�̲�", 110,300,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����", 150,355,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��������", 4,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ѩ��", 147,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("���¿���", 161,350,R.string.name_unit_ml));
	}
	//ơ��
	private void Add_PiJiu()
	{
		mAdapter.AddNewItem(new FootItem("�ྩơ��", 145,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("ѩ��ơ��", 140,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("������ơ", 144,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����ơ��", 151,350,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("����ơ��", 142,335,R.string.name_unit_ml));
		mAdapter.AddNewItem(new FootItem("��ʿ��", 70,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("÷��(��÷)", 71,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("���ؼ�", 100,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("Ѫ������", 123,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("��װ�����ķ��鼦β��", 237));
		mAdapter.AddNewItem(new FootItem("��װ������ʿ�ɼ�β�� ", 119));
		mAdapter.AddNewItem(new FootItem("����ζ�ͺ��", 126));
		mAdapter.AddNewItem(new FootItem("�ͺ����", 153));
		mAdapter.AddNewItem(new FootItem("��;�", 72));
		mAdapter.AddNewItem(new FootItem("õ��;�", 71));
		mAdapter.AddNewItem(new FootItem("�ײ;�", 68));
	}
	//��ʳ
	private void Add_ZhuShi()
	{
		mAdapter.AddNewItem(new FootItem("��ଷ�", 640,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("ʲ������", 800,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("ʲ������", 260,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("������", 392,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("ţ����", 540,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("�������", 600,1,R.string.name_unit_fen));
		mAdapter.AddNewItem(new FootItem("ʲ������", 860,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("ե����˿��", 400,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("ը����", 385,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�h����", 357,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���ȷ�", 690,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���ײ�", 149,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("ը��Ƭ", 302,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("ţ���߲���", 362,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�ȹ���", 263,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("ʲ������", 227,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���ⷹ", 713,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("������", 192,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�ŹǷ���", 480,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("������", 560,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("��˿��", 440,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("������", 470,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�׷�", 210,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("����ͷ", 280,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("���", 333));
		mAdapter.AddNewItem(new FootItem("��ͷ", 233));
		mAdapter.AddNewItem(new FootItem("����", 217));
		mAdapter.AddNewItem(new FootItem("С����", 200,5,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�����", 250,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("ˮ��", 420,10,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�˰�", 200,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ଽ�", 245,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����ˮ��", 40,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("��ɳ��", 215,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 255,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�����", 280,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("���հ�", 160,5,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("Сˮ���", 110,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�²˺���", 260,10,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����", 463));
		mAdapter.AddNewItem(new FootItem("�ձ�", 326));
		mAdapter.AddNewItem(new FootItem("����", 230,1,R.string.name_unit_ge));
	}
	//����
	private void Add_CaiYao()
	{
		mAdapter.AddNewItem(new FootItem("��������", 180,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���ʶ�Ƥ", 240));
		mAdapter.AddNewItem(new FootItem("����", 238));
		mAdapter.AddNewItem(new FootItem("����", 238));
		mAdapter.AddNewItem(new FootItem("�ӱ�", 225));
		mAdapter.AddNewItem(new FootItem("��ˮ��ͷ", 193));
		mAdapter.AddNewItem(new FootItem("������", 190));
		mAdapter.AddNewItem(new FootItem("����˾", 130));
		mAdapter.AddNewItem(new FootItem("�׷���", 185));
		mAdapter.AddNewItem(new FootItem("��˿", 335));
		mAdapter.AddNewItem(new FootItem("��Ƥ", 64));
		mAdapter.AddNewItem(new FootItem("����", 37));
		mAdapter.AddNewItem(new FootItem("����", 336));
		mAdapter.AddNewItem(new FootItem("����׷�", 350,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�׷���", 185,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���׷�", 275,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("�㶫��", 400,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("Ƥ��������", 367,1,R.string.name_unit_wan));
		mAdapter.AddNewItem(new FootItem("���ⷹ��", 205,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("����Ƥ", 489));
		mAdapter.AddNewItem(new FootItem("����", 489));
		mAdapter.AddNewItem(new FootItem("����Ƥ", 409));
		mAdapter.AddNewItem(new FootItem("���ָ���", 204));
		mAdapter.AddNewItem(new FootItem("����˿", 201));
		mAdapter.AddNewItem(new FootItem("Ѭ��", 153));
		mAdapter.AddNewItem(new FootItem("������", 151));
		mAdapter.AddNewItem(new FootItem("���", 147));
		mAdapter.AddNewItem(new FootItem("������", 140));
		mAdapter.AddNewItem(new FootItem("�Ϻ�����", 138));
		mAdapter.AddNewItem(new FootItem("�˸�", 68));
		mAdapter.AddNewItem(new FootItem("����", 133));
		mAdapter.AddNewItem(new FootItem("������", 130));
		mAdapter.AddNewItem(new FootItem("������", 98));
		mAdapter.AddNewItem(new FootItem("�϶���", 57));
		mAdapter.AddNewItem(new FootItem("�ᶹ��", 67));
		mAdapter.AddNewItem(new FootItem("�����", 612));
		mAdapter.AddNewItem(new FootItem("������", 337));
		mAdapter.AddNewItem(new FootItem("�عϷ�", 336));
		mAdapter.AddNewItem(new FootItem("����", 307));
		mAdapter.AddNewItem(new FootItem("����(����)", 64));
		mAdapter.AddNewItem(new FootItem("����(����)", 99));
		mAdapter.AddNewItem(new FootItem("������(��±)", 47));
		mAdapter.AddNewItem(new FootItem("��֭", 10));
		mAdapter.AddNewItem(new FootItem("�̶�͹", 320,1,R.string.name_unit_ge));
		mAdapter.AddNewItem(new FootItem("�춹��", 274));
		mAdapter.AddNewItem(new FootItem("����", 96));
		mAdapter.AddNewItem(new FootItem("�Ͳ�", 94));
		mAdapter.AddNewItem(new FootItem("����", 92));
		mAdapter.AddNewItem(new FootItem("С����", 61));
		mAdapter.AddNewItem(new FootItem("���⴮", 62,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("��Ѫ��", 130,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("���", 60,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("���װ�", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("�Ͷ���", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("���Ŵ�", 100,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("�㹽��", 90,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("����", 90,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("������", 70,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("�����", 70,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("��Ϻ��", 95,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("��ζ��", 80,1,R.string.name_unit_chuan));
		mAdapter.AddNewItem(new FootItem("����(Ѫ��)", 640));
		mAdapter.AddNewItem(new FootItem("����(������)", 591));
		mAdapter.AddNewItem(new FootItem("����(���廨)", 410));
		mAdapter.AddNewItem(new FootItem("����(Ӳ�廨)", 429));
		mAdapter.AddNewItem(new FootItem("����(ǰ���)", 504));
		mAdapter.AddNewItem(new FootItem("ţ��", 106));
		mAdapter.AddNewItem(new FootItem("ţ��", 72));
		mAdapter.AddNewItem(new FootItem("ţ����", 445));
		mAdapter.AddNewItem(new FootItem("ţ���", 550));
		mAdapter.AddNewItem(new FootItem("����", 118));
		mAdapter.AddNewItem(new FootItem("�Ǽ�", 325));
		mAdapter.AddNewItem(new FootItem("����", 328));
		mAdapter.AddNewItem(new FootItem("����", 121));
		mAdapter.AddNewItem(new FootItem("����", 172));
		mAdapter.AddNewItem(new FootItem("����", 262));
		mAdapter.AddNewItem(new FootItem("ɳ��", 358));
		mAdapter.AddNewItem(new FootItem("��Ѫ", 49));
		mAdapter.AddNewItem(new FootItem("�����", 215));
		mAdapter.AddNewItem(new FootItem("����", 88));
		mAdapter.AddNewItem(new FootItem("ʯ����", 561));
		mAdapter.AddNewItem(new FootItem("��Ϻ", 152));
	}

	//ơ��
	private void Add_TiaoWei()
	{
		mAdapter.AddNewItem(new FootItem("����", 10,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("ɳ����", 100,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("����", 50,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("ǧ��ɳ����", 60,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("������", 95,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("֥�齴", 14,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("���Ͷ��꽴", 180,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("�ƽ�", 140,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("��ÿڿڴ", 136,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("����(��)", 135,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("����", 97,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("���꽴", 10,1,R.string.name_unit_shi));
		mAdapter.AddNewItem(new FootItem("�״�", 93,1,R.string.name_unit_shi));
	}

}

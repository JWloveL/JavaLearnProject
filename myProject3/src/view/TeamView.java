package view;

import service.NameListService;
import service.TeamException;
import service.TeamService;
import domain.Employee;
import domain.Progammer;
public class TeamView {
	private NameListService listSvc=new NameListService();
	private TeamService teamSvc=new TeamService();
	
	public void enterMainMenu() {
		boolean loopFlag=true;
		char menu='0';
		while(loopFlag) {
			if(menu!='1')
				listAllEmployees();
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)");
			menu=TSUtlity.readMenuSelection();
			switch(menu) {
			case'1':
				getTeam();
				break;
			case'2':
				addMember();
				break;
			case'3':
				deleteMember();
				break;
			case'4':
				System.out.println("确认是否退出(Y/N)");
				char confirm=TSUtlity.readConfirmSelection();
				if(confirm=='Y') {
					loopFlag=false;
				}
				break;
			}
		}
	}
	private void listAllEmployees() {
		System.out.println("-------------------------------------开发团队调度软件-------------------------------------\n");
		Employee[] em=listSvc.getAllEmployees();
		if(em.length==0)
			System.out.println("没有任何员工信息！");
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		for(int i=0;i<em.length;i++) {
			System.out.println(em[i]);
		}
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	private void getTeam() {
//		System.out.println("团队所有成员信息");
		System.out.println("-------------------------团队成员列表--------------------------------\n");
		
		Progammer[] team=teamSvc.getTeam();
		if(team==null||team.length==0)
			System.out.println("开发团队中目前没有成员！");
		else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for(int i=0;i<team.length;i++)
				System.out.println(team[i].getDetailsForTeam());
		}
		System.out.println("---------------------------------------------------------------------");
	}
	private void addMember() {
		System.out.println("------------------------添加团队成员----------------------------------");
		System.out.println("请输入要添加员工的ID：");
		int id=TSUtlity.readInt();
		Employee a;
		try {
			a = listSvc.getEmployee(id);
			teamSvc.addMember(a);
			System.out.println("添加成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败，原因是:"+e.getMessage());
		}
		//按回车键继续
		TSUtlity.readReturn();
	}
	private void deleteMember() {
		System.out.println("------------------------删除团队成员-----------------------------------");
		System.out.println("请输入要删除员工的TID：");
		int memberId=TSUtlity.readInt();
		
		System.out.print("确认是否删除Y/N");
		char confirm=TSUtlity.readConfirmSelection();
		if(confirm=='N')
			return;
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败，原因是："+e.getMessage());
		}
		//按回车键继续
		TSUtlity.readReturn();
	}
	public static void main(String[] args) {
		TeamView tv=new TeamView();
		tv.enterMainMenu();
	}
}
 
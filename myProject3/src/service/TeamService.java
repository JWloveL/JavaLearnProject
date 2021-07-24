package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Progammer;

public class TeamService {
	
	private static int counter=1;
	private final int MAX_MEMBER=5;
	private Progammer[] team=new Progammer[MAX_MEMBER];
	private int total;
	public TeamService() {
		super();
	}
	public Progammer[] getTeam() {
		Progammer[] team=new Progammer[total];
		for(int i=0;i<total;i++) {
			team[i]=this.team[i];
		}
		return team;
	}
	public void addMember(Employee e) throws TeamException {
		//成员已满无法添加
		if(total>=MAX_MEMBER) {
			throw new TeamException("成员已满无法添加");
		}
		//该成员不是开发成员，无法添加
		if(!(e instanceof Progammer)) {
			throw new TeamException("该成员不是开发成员，无法添加");
		}
		//该员工已在本开发团队中
		if((isExist(e))) {
			throw new TeamException("该员工已在本开发团队中");

		}
		//该员已是某团队成员
		//该员正在休假，无法添加
		Progammer p=(Progammer)e;
//		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员已是某团队成员");
//		}
//		else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员正在休假，无法添加");
//		}
		switch (p.getStatus()){
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员正在休假，无法添加");
		}
		//团队中至多只能有一名架构师
		//团队中至多只能有两名设计师
		//团队中至多只能有三名程序员
		int numOfpro=0,numOfdes=0,numOfAr=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect)
				numOfAr++;
			else if(team[i] instanceof Designer)
				numOfdes++;
			else if(team[i] instanceof Progammer)
				numOfpro++;
		}
		if(p instanceof Architect) {
			if(numOfAr>=1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}
		else if(p instanceof Designer) {
			if(numOfdes>=2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}
		else if(p instanceof Progammer) {
			if(numOfpro>=3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		p.setStatus(Status.BUSY);
		p.setMemberid(counter++);
		
		team[total++]=p;
	}
	private boolean isExist(Employee e) {
		// TODO Auto-generated method stub
		for(int i=0;i<total;i++) {
			return e.getId()==team[i].getId();
		}
		return false;
	}
	/**
	 * 从团队中删除成员
	 * @param memberid
	 * @throws TeamException 
	 */
	public void removeMember(int memberid) throws TeamException {
		int i=0;
		for(;i<total;i++) {
			if(memberid==team[i].getMemberid()) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i==total) {
			throw new TeamException("找不到指定员工的memberid,删除失败");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1]=team[j];
		}
		team[total--]=null;
		
	}
}

import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"工资单", menuFor: "employeeSalarySheet",
=======

const menuData = {menuName: window.trans('employee_salary_sheet'), menuFor: "employeeSalarySheet",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('employee_salary_sheet'), menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_salary_sheet.id'),
  employee: window.trans('employee_salary_sheet.employee'),
  currentSalaryGrade: window.trans('employee_salary_sheet.current_salary_grade'),
  baseSalary: window.trans('employee_salary_sheet.base_salary'),
  bonus: window.trans('employee_salary_sheet.bonus'),
  reward: window.trans('employee_salary_sheet.reward'),
  personalTax: window.trans('employee_salary_sheet.personal_tax'),
  socialSecurity: window.trans('employee_salary_sheet.social_security'),
  housingFound: window.trans('employee_salary_sheet.housing_found'),
  jobInsurance: window.trans('employee_salary_sheet.job_insurance'),
  payingOff: window.trans('employee_salary_sheet.paying_off'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSalarySheet') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentSalaryGrade, dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseSalary, dataIndex: 'baseSalary', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.bonus, dataIndex: 'bonus', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.reward, dataIndex: 'reward', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.personalTax, dataIndex: 'personalTax', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.socialSecurity, dataIndex: 'socialSecurity', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.housingFound, dataIndex: 'housingFound', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.jobInsurance, dataIndex: 'jobInsurance', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.payingOff, dataIndex: 'payingOff', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeSalarySheet,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeSalarySheet.id}>
	
      <DescriptionList  key={employeeSalarySheet.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeSalarySheet.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeSalarySheet.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.employee.displayName}(${employeeSalarySheet.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.currentSalaryGrade}><div>{employeeSalarySheet.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.currentSalaryGrade.displayName}(${employeeSalarySheet.currentSalaryGrade.id})`}
        </div></Description>
        <Description term={fieldLabels.baseSalary}><div style={{"color":"red"}}>{employeeSalarySheet.baseSalary}</div></Description> 
        <Description term={fieldLabels.bonus}><div style={{"color":"red"}}>{employeeSalarySheet.bonus}</div></Description> 
        <Description term={fieldLabels.reward}><div style={{"color":"red"}}>{employeeSalarySheet.reward}</div></Description> 
        <Description term={fieldLabels.personalTax}><div style={{"color":"red"}}>{employeeSalarySheet.personalTax}</div></Description> 
        <Description term={fieldLabels.socialSecurity}><div style={{"color":"red"}}>{employeeSalarySheet.socialSecurity}</div></Description> 
        <Description term={fieldLabels.housingFound}><div style={{"color":"red"}}>{employeeSalarySheet.housingFound}</div></Description> 
        <Description term={fieldLabels.jobInsurance}><div style={{"color":"red"}}>{employeeSalarySheet.jobInsurance}</div></Description> 
        <Description term={fieldLabels.payingOff}><div>{employeeSalarySheet.payingOff==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.payingOff.displayName}(${employeeSalarySheet.payingOff.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"工资单", menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  employee: '员工',
  currentSalaryGrade: '目前工资等级',
  baseSalary: '基本工资',
  bonus: '奖金',
  reward: '奖励',
  personalTax: '个人所得税',
  socialSecurity: '社会保险',
  housingFound: '住房公积金',
  jobInsurance: '失业保险',
  payingOff: '工资支付',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSalarySheet') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentSalaryGrade, dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseSalary, dataIndex: 'baseSalary', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.bonus, dataIndex: 'bonus', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.reward, dataIndex: 'reward', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.personalTax, dataIndex: 'personalTax', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.socialSecurity, dataIndex: 'socialSecurity', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.housingFound, dataIndex: 'housingFound', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.jobInsurance, dataIndex: 'jobInsurance', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.payingOff, dataIndex: 'payingOff', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '12',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeSalarySheet,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeSalarySheet.id}>
	
      <DescriptionList  key={employeeSalarySheet.id} size="small" col="4">
        <Description term="序号">{employeeSalarySheet.id}</Description> 
        <Description term="员工"><div>{employeeSalarySheet.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.employee.displayName}(${employeeSalarySheet.employee.id})`}
        </div></Description>
        <Description term="目前工资等级"><div>{employeeSalarySheet.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.currentSalaryGrade.displayName}(${employeeSalarySheet.currentSalaryGrade.id})`}
        </div></Description>
        <Description term="基本工资"><div style={{"color":"red"}}>{employeeSalarySheet.baseSalary}</div></Description> 
        <Description term="奖金"><div style={{"color":"red"}}>{employeeSalarySheet.bonus}</div></Description> 
        <Description term="奖励"><div style={{"color":"red"}}>{employeeSalarySheet.reward}</div></Description> 
        <Description term="个人所得税"><div style={{"color":"red"}}>{employeeSalarySheet.personalTax}</div></Description> 
        <Description term="社会保险"><div style={{"color":"red"}}>{employeeSalarySheet.socialSecurity}</div></Description> 
        <Description term="住房公积金"><div style={{"color":"red"}}>{employeeSalarySheet.housingFound}</div></Description> 
        <Description term="失业保险"><div style={{"color":"red"}}>{employeeSalarySheet.jobInsurance}</div></Description> 
        <Description term="工资支付"><div>{employeeSalarySheet.payingOff==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.payingOff.displayName}(${employeeSalarySheet.payingOff.id})`}
        </div></Description>
        <Description term="当前状态">{employeeSalarySheet.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const currentSalaryGrade = {id: currentSalaryGradeId, version: 2^31}
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const currentSalaryGradeId = currentSalaryGrade ? currentSalaryGrade.id : null
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId}
	return data
}

const EmployeeSalarySheetBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId, payingOffId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const currentSalaryGrade = {id: currentSalaryGradeId, version: 2^31}
	const payingOff = {id: payingOffId, version: 2^31}
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade, payingOff}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employee, currentSalaryGrade, payingOff} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const currentSalaryGradeId = currentSalaryGrade ? currentSalaryGrade.id : null
	const payingOffId = payingOff ? payingOff.id : null
	const data = {baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance, employeeId, currentSalaryGradeId, payingOffId}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const EmployeeSalarySheetBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeSalarySheetBase




import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"工资单", menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}

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
	



const EmployeeSalarySheetBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeSalarySheetBase




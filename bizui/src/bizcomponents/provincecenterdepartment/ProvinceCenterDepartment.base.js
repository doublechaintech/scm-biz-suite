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


const menuData = {menuName:"Province Center Department", menuFor: "provinceCenterDepartment",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName:'Province Center Employee', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  founded: 'Founded',
  provinceCenter: 'Province Center',
  manager: 'Manager',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'provinceCenterDepartment') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.manager, debugtype: 'string', dataIndex: 'manager', width: '7',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(provinceCenterDepartment,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={provinceCenterDepartment.id}>
	
	<DescriptionList  key={provinceCenterDepartment.id} size="small" col="4">
<Description term="Id">{provinceCenterDepartment.id}</Description> 
<Description term="Name">{provinceCenterDepartment.name}</Description> 
<Description term="Founded">{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Province Center">{provinceCenterDepartment.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterDepartment.provinceCenter.displayName}(${provinceCenterDepartment.provinceCenter.id})`}
</Description>
<Description term="Manager">{provinceCenterDepartment.manager}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ProvinceCenterDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProvinceCenterDepartmentBase




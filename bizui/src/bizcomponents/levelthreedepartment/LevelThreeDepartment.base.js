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


const menuData = {menuName:"Level Three Department", menuFor: "levelThreeDepartment",
  		subItems: [
  {name: 'employeeList', displayName:'Employee', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  belongsTo: 'Belongs To',
  name: 'Name',
  description: 'Description',
  founded: 'Founded',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'levelThreeDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelThreeDepartment,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={levelThreeDepartment.id}>
	
	<DescriptionList  key={levelThreeDepartment.id} size="small" col="4">
<Description term="Id">{levelThreeDepartment.id}</Description> 
<Description term="Belongs To">{levelThreeDepartment.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${levelThreeDepartment.belongsTo.displayName}(${levelThreeDepartment.belongsTo.id})`}
</Description>
<Description term="Name">{levelThreeDepartment.name}</Description> 
<Description term="Description">{levelThreeDepartment.description}</Description> 
<Description term="Founded">{ moment(levelThreeDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const LevelThreeDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LevelThreeDepartmentBase




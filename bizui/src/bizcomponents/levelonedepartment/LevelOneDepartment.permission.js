

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LevelOneDepartment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (levelOneDepartment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelOneDepartment.id}</Description> 
<Description term="名称">{levelOneDepartment.name}</Description> 
<Description term="描述">{levelOneDepartment.description}</Description> 
<Description term="经理的名字">{levelOneDepartment.managerName}</Description> 
<Description term="成立">{ moment(levelOneDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = levelOneDepartment => {
  const {LevelOneDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={levelOneDepartment}  targetObjectMeta={LevelOneDepartmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LevelOneDepartmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  levelOneDepartment = this.props.levelOneDepartment
    const { id,displayName, levelTwoDepartmentCount } = levelOneDepartment
    const  returnURL = `/levelOneDepartment/${id}/dashboard`
    const cardsData = {cardsName:"一级部门",cardsFor: "levelOneDepartment",cardsSource: levelOneDepartment,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  levelOneDepartment: state._levelOneDepartment,
}))(Form.create()(LevelOneDepartmentPermission))


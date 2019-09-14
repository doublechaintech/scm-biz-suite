

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LevelTwoDepartment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (levelTwoDepartment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelTwoDepartment.id}</Description> 
<Description term="名称">{levelTwoDepartment.name}</Description> 
<Description term="描述">{levelTwoDepartment.description}</Description> 
<Description term="成立">{ moment(levelTwoDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = levelTwoDepartment => {
  const {LevelTwoDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={levelTwoDepartment}  targetObjectMeta={LevelTwoDepartmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LevelTwoDepartmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  levelTwoDepartment = this.props.levelTwoDepartment
    const { id,displayName, levelThreeDepartmentCount } = levelTwoDepartment
    const  returnURL = `/levelTwoDepartment/${id}/dashboard`
    const cardsData = {cardsName:"二级部门",cardsFor: "levelTwoDepartment",cardsSource: levelTwoDepartment,displayName,returnURL,
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
  levelTwoDepartment: state._levelTwoDepartment,
}))(Form.create()(LevelTwoDepartmentPermission))


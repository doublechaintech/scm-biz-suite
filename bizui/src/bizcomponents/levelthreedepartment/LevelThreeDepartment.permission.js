

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LevelThreeDepartment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (levelThreeDepartment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{levelThreeDepartment.id}</Description> 
<Description term="Name">{levelThreeDepartment.name}</Description> 
<Description term="Description">{levelThreeDepartment.description}</Description> 
<Description term="Founded">{ moment(levelThreeDepartment.founded).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = levelThreeDepartment => {
  const {LevelThreeDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={levelThreeDepartment}  targetObjectMeta={LevelThreeDepartmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LevelThreeDepartmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  levelThreeDepartment = this.props.levelThreeDepartment;
    const { id,displayName, employeeCount } = levelThreeDepartment
    const cardsData = {cardsName:"Level Three Department",cardsFor: "levelThreeDepartment",cardsSource: levelThreeDepartment,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  levelThreeDepartment: state._levelThreeDepartment,
}))(Form.create()(LevelThreeDepartmentPermission))


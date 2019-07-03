

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
import styles from './TrainingCourseType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (trainingCourseType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{trainingCourseType.id}</Description> 
<Description term="代码">{trainingCourseType.code}</Description> 
<Description term="名称">{trainingCourseType.name}</Description> 
<Description term="描述">{trainingCourseType.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = trainingCourseType => {
  const {TrainingCourseTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={trainingCourseType}  targetObjectMeta={TrainingCourseTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TrainingCourseTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  trainingCourseType = this.props.trainingCourseType;
    const { id,displayName, companyTrainingCount } = trainingCourseType
    const cardsData = {cardsName:"培训课程类型",cardsFor: "trainingCourseType",cardsSource: trainingCourseType,
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
  trainingCourseType: state._trainingCourseType,
}))(Form.create()(TrainingCourseTypePermission))


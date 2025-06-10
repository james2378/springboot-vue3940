<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="新闻资讯"
				source_table="article"
			  ></list_result_search>
				<!-- 论坛搜索结果 -->
			  <list_result_search
				:list="result_forum"
				title="论坛"
				source_table="forum"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/user_registration/list', 'get')"
				:list="result_user_registration_id"
				title="用户注册身份证"
				source_table="user_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccinator_information/list', 'get')"
				:list="result_vaccinator_information_name_of_vaccinator"
				title="接种者信息接种者姓名"
				source_table="vaccinator_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccinator_information/list', 'get')"
				:list="result_vaccinator_information_gender"
				title="接种者信息性别"
				source_table="vaccinator_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccine_information/list', 'get')"
				:list="result_vaccine_information_vaccine_type"
				title="疫苗信息疫苗类型"
				source_table="vaccine_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccine_information/list', 'get')"
				:list="result_vaccine_information_vaccine_name"
				title="疫苗信息疫苗名称"
				source_table="vaccine_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccine_information/list', 'get')"
				:list="result_vaccine_information_vaccine_producing_area"
				title="疫苗信息疫苗出产地"
				source_table="vaccine_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/appointment_vaccine/list', 'get')"
				:list="result_appointment_vaccine_vaccine_type"
				title="预约疫苗疫苗类型"
				source_table="appointment_vaccine"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/appointment_vaccine/list', 'get')"
				:list="result_appointment_vaccine_vaccine_name"
				title="预约疫苗疫苗名称"
				source_table="appointment_vaccine"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/warehoused_vaccine/list', 'get')"
				:list="result_warehoused_vaccine_vaccine_type"
				title="入库疫苗疫苗类型"
				source_table="warehoused_vaccine"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/warehoused_vaccine/list', 'get')"
				:list="result_warehoused_vaccine_vaccine_name"
				title="入库疫苗疫苗名称"
				source_table="warehoused_vaccine"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reservation_plan/list', 'get')"
				:list="result_reservation_plan_vaccine_number"
				title="预约计划疫苗编号"
				source_table="reservation_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reservation_plan/list', 'get')"
				:list="result_reservation_plan_vaccine_type"
				title="预约计划疫苗类型"
				source_table="reservation_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reservation_plan/list', 'get')"
				:list="result_reservation_plan_vaccine_name"
				title="预约计划疫苗名称"
				source_table="reservation_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccine_delivery/list', 'get')"
				:list="result_vaccine_delivery_vaccine_type"
				title="出库疫苗疫苗类型"
				source_table="vaccine_delivery"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccine_delivery/list', 'get')"
				:list="result_vaccine_delivery_vaccine_name"
				title="出库疫苗疫苗名称"
				source_table="vaccine_delivery"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccination_record/list', 'get')"
				:list="result_vaccination_record_vaccine_type"
				title="接种记录疫苗类型"
				source_table="vaccination_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccination_record/list', 'get')"
				:list="result_vaccination_record_vaccine_name"
				title="接种记录疫苗名称"
				source_table="vaccination_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/vaccination_record/list', 'get')"
				:list="result_vaccination_record_vaccine_batch"
				title="接种记录疫苗批次"
				source_table="vaccination_record"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
	  "result_forum": [],
			"result_user_registration_id":[],
			"result_vaccinator_information_name_of_vaccinator":[],
			"result_vaccinator_information_gender":[],
			"result_vaccine_information_vaccine_type":[],
			"result_vaccine_information_vaccine_name":[],
			"result_vaccine_information_vaccine_producing_area":[],
			"result_appointment_vaccine_vaccine_type":[],
			"result_appointment_vaccine_vaccine_name":[],
			"result_warehoused_vaccine_vaccine_type":[],
			"result_warehoused_vaccine_vaccine_name":[],
			"result_reservation_plan_vaccine_number":[],
			"result_reservation_plan_vaccine_type":[],
			"result_reservation_plan_vaccine_name":[],
			"result_vaccine_delivery_vaccine_type":[],
			"result_vaccine_delivery_vaccine_name":[],
			"result_vaccination_record_vaccine_type":[],
			"result_vaccination_record_vaccine_name":[],
			"result_vaccination_record_vaccine_batch":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取论坛
	 */
	get_forum() {
	  this.$get("~/api/forum/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_forum = json.result.list;
		}
	  });
	},
	/**
	 * 获取id
	 */
	get_user_registration_id(){
		this.$get("~/api/user_registration/get_list?like=0", { page: 1, size: 10, "id": this.query.word }, (json) => {
		  if (json.result) {
			var result_user_registration_id = json.result.list;
			result_user_registration_id.map(o => o.title = o['id'])
	  			this.result_user_registration_id = result_user_registration_id
		 	}
		});
	},
	/**
	 * 获取name_of_vaccinator
	 */
	get_vaccinator_information_name_of_vaccinator(){
		this.$get("~/api/vaccinator_information/get_list?like=0", { page: 1, size: 10, "name_of_vaccinator": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccinator_information_name_of_vaccinator = json.result.list;
			result_vaccinator_information_name_of_vaccinator.map(o => o.title = o['name_of_vaccinator'])
	  			this.result_vaccinator_information_name_of_vaccinator = result_vaccinator_information_name_of_vaccinator
		 	}
		});
	},
	/**
	 * 获取gender
	 */
	get_vaccinator_information_gender(){
		this.$get("~/api/vaccinator_information/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccinator_information_gender = json.result.list;
			result_vaccinator_information_gender.map(o => o.title = o['gender'])
	  			this.result_vaccinator_information_gender = result_vaccinator_information_gender
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_vaccine_information_vaccine_type(){
		this.$get("~/api/vaccine_information/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccine_information_vaccine_type = json.result.list;
			result_vaccine_information_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_vaccine_information_vaccine_type = result_vaccine_information_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_vaccine_information_vaccine_name(){
		this.$get("~/api/vaccine_information/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccine_information_vaccine_name = json.result.list;
			result_vaccine_information_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_vaccine_information_vaccine_name = result_vaccine_information_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_producing_area
	 */
	get_vaccine_information_vaccine_producing_area(){
		this.$get("~/api/vaccine_information/get_list?like=0", { page: 1, size: 10, "vaccine_producing_area": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccine_information_vaccine_producing_area = json.result.list;
			result_vaccine_information_vaccine_producing_area.map(o => o.title = o['vaccine_producing_area'])
	  			this.result_vaccine_information_vaccine_producing_area = result_vaccine_information_vaccine_producing_area
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_appointment_vaccine_vaccine_type(){
		this.$get("~/api/appointment_vaccine/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_appointment_vaccine_vaccine_type = json.result.list;
			result_appointment_vaccine_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_appointment_vaccine_vaccine_type = result_appointment_vaccine_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_appointment_vaccine_vaccine_name(){
		this.$get("~/api/appointment_vaccine/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_appointment_vaccine_vaccine_name = json.result.list;
			result_appointment_vaccine_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_appointment_vaccine_vaccine_name = result_appointment_vaccine_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_warehoused_vaccine_vaccine_type(){
		this.$get("~/api/warehoused_vaccine/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_warehoused_vaccine_vaccine_type = json.result.list;
			result_warehoused_vaccine_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_warehoused_vaccine_vaccine_type = result_warehoused_vaccine_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_warehoused_vaccine_vaccine_name(){
		this.$get("~/api/warehoused_vaccine/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_warehoused_vaccine_vaccine_name = json.result.list;
			result_warehoused_vaccine_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_warehoused_vaccine_vaccine_name = result_warehoused_vaccine_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_number
	 */
	get_reservation_plan_vaccine_number(){
		this.$get("~/api/reservation_plan/get_list?like=0", { page: 1, size: 10, "vaccine_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_reservation_plan_vaccine_number = json.result.list;
			result_reservation_plan_vaccine_number.map(o => o.title = o['vaccine_number'])
	  			this.result_reservation_plan_vaccine_number = result_reservation_plan_vaccine_number
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_reservation_plan_vaccine_type(){
		this.$get("~/api/reservation_plan/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_reservation_plan_vaccine_type = json.result.list;
			result_reservation_plan_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_reservation_plan_vaccine_type = result_reservation_plan_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_reservation_plan_vaccine_name(){
		this.$get("~/api/reservation_plan/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_reservation_plan_vaccine_name = json.result.list;
			result_reservation_plan_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_reservation_plan_vaccine_name = result_reservation_plan_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_vaccine_delivery_vaccine_type(){
		this.$get("~/api/vaccine_delivery/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccine_delivery_vaccine_type = json.result.list;
			result_vaccine_delivery_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_vaccine_delivery_vaccine_type = result_vaccine_delivery_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_vaccine_delivery_vaccine_name(){
		this.$get("~/api/vaccine_delivery/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccine_delivery_vaccine_name = json.result.list;
			result_vaccine_delivery_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_vaccine_delivery_vaccine_name = result_vaccine_delivery_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_type
	 */
	get_vaccination_record_vaccine_type(){
		this.$get("~/api/vaccination_record/get_list?like=0", { page: 1, size: 10, "vaccine_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccination_record_vaccine_type = json.result.list;
			result_vaccination_record_vaccine_type.map(o => o.title = o['vaccine_type'])
	  			this.result_vaccination_record_vaccine_type = result_vaccination_record_vaccine_type
		 	}
		});
	},
	/**
	 * 获取vaccine_name
	 */
	get_vaccination_record_vaccine_name(){
		this.$get("~/api/vaccination_record/get_list?like=0", { page: 1, size: 10, "vaccine_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccination_record_vaccine_name = json.result.list;
			result_vaccination_record_vaccine_name.map(o => o.title = o['vaccine_name'])
	  			this.result_vaccination_record_vaccine_name = result_vaccination_record_vaccine_name
		 	}
		});
	},
	/**
	 * 获取vaccine_batch
	 */
	get_vaccination_record_vaccine_batch(){
		this.$get("~/api/vaccination_record/get_list?like=0", { page: 1, size: 10, "vaccine_batch": this.query.word }, (json) => {
		  if (json.result) {
			var result_vaccination_record_vaccine_batch = json.result.list;
			result_vaccination_record_vaccine_batch.map(o => o.title = o['vaccine_batch'])
	  			this.result_vaccination_record_vaccine_batch = result_vaccination_record_vaccine_batch
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
	this.get_forum();
		this.get_user_registration_id();
		this.get_vaccinator_information_name_of_vaccinator();
		this.get_vaccinator_information_gender();
		this.get_vaccine_information_vaccine_type();
		this.get_vaccine_information_vaccine_name();
		this.get_vaccine_information_vaccine_producing_area();
		this.get_appointment_vaccine_vaccine_type();
		this.get_appointment_vaccine_vaccine_name();
		this.get_warehoused_vaccine_vaccine_type();
		this.get_warehoused_vaccine_vaccine_name();
		this.get_reservation_plan_vaccine_number();
		this.get_reservation_plan_vaccine_type();
		this.get_reservation_plan_vaccine_name();
		this.get_vaccine_delivery_vaccine_type();
		this.get_vaccine_delivery_vaccine_name();
		this.get_vaccination_record_vaccine_type();
		this.get_vaccination_record_vaccine_name();
		this.get_vaccination_record_vaccine_batch();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_forum();
	  this.get_user_registration_id();
	  this.get_vaccinator_information_name_of_vaccinator();
	  this.get_vaccinator_information_gender();
	  this.get_vaccine_information_vaccine_type();
	  this.get_vaccine_information_vaccine_name();
	  this.get_vaccine_information_vaccine_producing_area();
	  this.get_appointment_vaccine_vaccine_type();
	  this.get_appointment_vaccine_vaccine_name();
	  this.get_warehoused_vaccine_vaccine_type();
	  this.get_warehoused_vaccine_vaccine_name();
	  this.get_reservation_plan_vaccine_number();
	  this.get_reservation_plan_vaccine_type();
	  this.get_reservation_plan_vaccine_name();
	  this.get_vaccine_delivery_vaccine_type();
	  this.get_vaccine_delivery_vaccine_name();
	  this.get_vaccination_record_vaccine_type();
	  this.get_vaccination_record_vaccine_name();
	  this.get_vaccination_record_vaccine_batch();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
